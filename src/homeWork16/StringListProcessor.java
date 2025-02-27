package homeWork16;

public class StringListProcessor {
    public static int countUppercase(String s){
        return (int) s.chars().filter(Character::isUpperCase).count();
    }

    }
