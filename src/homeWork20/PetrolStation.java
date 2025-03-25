package homeWork20;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private int amount;
    private final Semaphore semaphore = new Semaphore(3);

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
    }

    public void doRefuel(int columnNumber, int fuel) {
        synchronized (this) {
            if (amount == 0) {
                System.out.println("Column " + columnNumber + ": Fuel is out! ");
                return;
            }
        }

        try {
            semaphore.acquire();

            synchronized (this) {
                if (fuel <= amount) {
                    System.out.println("Column " + columnNumber + ": Refueling " + fuel + " liters .");
                    Thread.sleep((3 + (int) (Math.random() * 8)) * 1000L);
                    amount -= fuel;
                    System.out.println("Column " + columnNumber + ": Tucked in " + fuel +
                            " liters . Balance: " + amount + " liters .");
                } else {
                    System.out.println("Column " + columnNumber +
                            ": Not enough fuel! Remaining fuel: " + amount + " liters .");
                }
            }
        } catch (InterruptedException ei) {
            System.out.println("Column " + columnNumber + ": Refueling interrupted!");
        } finally {
            semaphore.release();
        }
    }
}