package homeWork24;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First ");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second ");

        System.out.println(logger1 == logger2);
    }

}
