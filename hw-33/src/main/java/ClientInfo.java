import java.net.Socket;
import java.time.LocalDateTime;

public class ClientInfo {
    private final String name;
    private final LocalDateTime connectedTime;
    private final Socket socket;

    public ClientInfo(String name, LocalDateTime connectedTime, Socket socket) {
        this.name = name;
        this.connectedTime = connectedTime;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getConnectedTime() {
        return connectedTime;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "name='" + name + '\'' +
                ", connectedAt=" + connectedTime +
                ", address=" + socket.getRemoteSocketAddress() +
                '}';
    }
}