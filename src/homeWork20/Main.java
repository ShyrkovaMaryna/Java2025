package homeWork20;
public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(200);

        for (int i = 0; i <6; i++) {
            int columnNumber = i + 1;
            int fuelAmount = 10 + (int) (Math.random() * 61);

            new Thread(() -> petrolStation.doRefuel(columnNumber, fuelAmount)).start();
        }
    }
}
