public class Banker extends Person {
    public Banker(String name, int age, String phone) {
        super(name, age, phone);
    }

    @Override
    public void sayHi() {
        System.out.println("Hi there! My name is " + this.name + ".\nHow can I help you?");
    }

    public static void main(String[] args) {
        Banker banker = new Banker("Markus", 26, "010-9090-8080");
        banker.sayHi();
    }
}
