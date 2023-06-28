//2-1 클래스와 인스턴스
public class Person {
    String name;
    int age;
    String phone;

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void sayHi() {
        System.out.println("Hi there! My name is " + name);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Chaerin", 24, "010-9399-3872");
        Person person2 = new Person("Markus", 26, "010-9090-8080");
        person1.sayHi();
        person2.sayHi();
    }
}
