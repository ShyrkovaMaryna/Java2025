package homeWork26;

public class User {
    private final String name;
    private Address address;

    public User(String name){
        this.name = name;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    public void printUserInfo(){
        System.out.println("User: " + name);
        System.out.println("Address: " + address);
    }
}
