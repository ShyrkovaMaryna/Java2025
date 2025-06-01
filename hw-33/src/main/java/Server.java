import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args)
            throws IOException {
        AtomicInteger clientIdGenerator = new AtomicInteger(1);
        Map<String, ClientInfo> activeClients = new ConcurrentHashMap<>();

        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            logger.info("Server is running)");

            while (true) {
                Socket socket = serverSocket.accept();

                new Thread(() -> {
                    String clientName = "client(" + clientIdGenerator.getAndIncrement()+ ")";
                    LocalDateTime connectTime = LocalDateTime.now();
                    ClientInfo clientInfo = new ClientInfo(clientName, connectTime, socket);
                    activeClients.put(clientName, clientInfo);

                    logger.info("|SERVER| " + clientName + " connected successfully: " + clientInfo);

                    try (
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)
                    ) {
                        printWriter.println("|SERVER| You are connected as " + clientName);
                        String message;
                        while ((message = bufferedReader.readLine()) != null) {
                            if (message.equalsIgnoreCase("exit")) {
                                printWriter.println("|SERVER| Goodbye " + clientName);
                                break;
                            } else {
                                printWriter.println("|SERVER| Command: " + message);
                                logger.info(clientName + " Sent the command : " + message);
                            }
                        }
                    } catch (IOException e) {
                        logger.log(Level.WARNING, "At the client " + clientName + " error " + e);
                    } finally {
                        activeClients.remove(clientName);
                        try {
                            socket.close();
                        } catch (IOException ignored) {}
                        logger.info("|SERVER| " + clientName + " disconnected");
                    }
                }).start();
            }
        }
    }
}