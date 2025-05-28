public class Order {
    private final int orderNumber;
    private final String clientName;

    public Order(int orderNumber, String clientName) {
        this.orderNumber = orderNumber;
        this.clientName = clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    @Override
    public String toString() {
        return orderNumber + " | " + clientName;
    }
}