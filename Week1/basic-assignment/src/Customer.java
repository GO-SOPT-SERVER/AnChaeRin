//2-4 상속

enum RequestType {WITHDRAW, DEPOSIT}

public class Customer extends Person {
    private String accountId;

    public Customer(String name, int age, String phone, String accountId) {
        super(name, age, phone); // 부모의 생성자
        this.accountId = accountId;
    }

    public String request(RequestType req, String name) {
        return String.format("%s: I want to %s", this.name, req);
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Chaerin", 24, "010-9399-3872", "#123");
        String request = customer.request(RequestType.DEPOSIT, customer.name);
        System.out.println(request);
    }
}
