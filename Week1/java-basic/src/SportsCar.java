public class SportsCar implements Car {
    @Override
    public void turnOn() {
        System.out.println("스포츠카 시동 켜기");
    }

    @Override
    public void turnOff() {
        System.out.println("스포츠카 시동 끄기");
    }

    public static void main(String[] args) {
       SportsCar sportsCar=new SportsCar();
       sportsCar.turnOff();
       sportsCar.turnOn();
    }
}