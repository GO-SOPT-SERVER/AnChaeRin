//2-4 상속

enum RequestType {WITHDRAW, DEPOSIT}

public class Customer extends Person {
    private String accountId;

    public Customer(String name, int age, String phone, String accountId) {
        super(name, age, phone); // 부모의 생성자
        this.accountId = accountId;
    }

    public String request(RequestType req, String name) {
//        available case: this.name, super.name, name
        return String.format("%s: I want to %s", super.name, req);
    }

    public String request(RequestType req, String name, int amount) {
        return String.format("%s: I want to %s\n The amount is $%d.", this.name, req, amount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Chaerin", 24, "010-9399-3872", "#123");
        String request1 = customer.request(RequestType.DEPOSIT, customer.name);
        String request2 = customer.request(RequestType.WITHDRAW, customer.name, 30);
        System.out.println(request1);
        System.out.println(request2);
    }
}
