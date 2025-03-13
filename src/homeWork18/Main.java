package homeWork18;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user1 = new User(1, "Petro", "Petro@gmail.com.ua");
        User user2 = new User(2, "Maryna", "Maryna@gmail.com.ua");
        User user3 = new User(3, "Tanya", "Tanya@gmail.com.ua");

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);

        int searchId = 3;
        userRepository.findUserById(searchId).ifPresentOrElse(
                user -> System.out.println("User found by ID: " + user),
                () -> System.out.println("User with ID " + searchId + " not found.")
        );

        String searchEmail = "Tanya@gmail.com.ua";
        userRepository.findUserByEmail(searchEmail).ifPresentOrElse(
                user -> System.out.println("User found by Email: " + user),
                () -> System.out.println("User with email " + searchEmail + " not found.")
        );

        userRepository.findAllUsers().ifPresentOrElse(
                userList -> System.out.println("Found users = " + userList.size()),
                () -> System.out.println("No users found.")
        );


    }

}
