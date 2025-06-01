import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1111)) {
            logger.info("You are connected to the server");

            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    Scanner scanner = new Scanner(System.in)
            ) {
                System.out.println(reader.readLine());

                while (true) {
                    System.out.print(">>> ");
                    String input = scanner.nextLine();
                    writer.println(input);

                    String response = reader.readLine();
                    if (response == null) break;

                    System.out.println(response);

                    if (input.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to connect to the server", e);
        }
    }
}