class GenericClass <T> {
    T type;
}

public class GenericTest {
    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new GenericClass<Integer>();
        genericClass.type = 12;
        System.out.println(genericClass.type);
    }
}