import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private  final static Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final Queue<Order> orders = new LinkedList<>();;
    private int nextOrderNumber = 1;

    public void add(String orderName) {
        Order order = new Order(nextOrderNumber++, orderName);
        orders.add(order);
        LOGGER.info("Order added: {}", order);
    }

    public void deliver() {
        Order order = orders.poll();
        if (order == null) {
            LOGGER.warn("Attempting to issue an order when the queue is empty.");
            return;
        }
        orders.remove(order);
        LOGGER.info("An order has been placed: {}", order);
    }

    public void deliver(int orderNumber) {
        try {
            Iterator<Order> iterator = orders.iterator();
            while (iterator.hasNext()) {
                Order order = iterator.next();
                if (order.getOrderNumber() == orderNumber){
                    iterator.remove();
                    LOGGER.info("The order was issued by number: {}", order);
                    return;
                }
            }
            throw new  RuntimeException("Order with number " + orderNumber + " not found.");
        } catch (Exception e) {
            LOGGER.error("Error when issuing an order with a number {}: {}", orderNumber, e.getMessage(), e);
        }
    }

        public void draw (){
            System.out.println("Num | Name");
            orders.forEach(System.out::println);
            LOGGER.debug("The current state of the queue is displayed.");
        }
    }
