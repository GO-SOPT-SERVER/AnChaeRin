//2-1 클래스와 인스턴스
public class Person {
    private String name;
    private int age;
    private String phone;

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void sayHi() {
        System.out.println("Hi there! My name is " + name);
    }

    public static void main(String[] args) {
        Person person = new Person("Chaerin", 24, "010-9399-3872");
        person.sayHi();
    }
}
