public class Dog extends Animal {
    private String gender;

    public void walk() {
        System.out.println("강아지가 산책을 합니다.");
    }

    public void bark() {
        System.out.println("월월");
    }

    @Override
    public void speak() {
        System.out.println("월월");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.drink();
        dog.speak();
    }
}