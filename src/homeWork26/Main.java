package homeWork26;

public class Main {
    public static void main(String[] args) {
        User user = new User("Marina");
        Address address = new Address("Berestyn", "Poltavska", 5);

        user.setAddress(address);
        user.printUserInfo();
    }
}
