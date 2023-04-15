//2-5-4 abstract class
public class PersonalAccount extends BasicAccount {
    private String owner;

    PersonalAccount(String owner) {
        this.owner = owner;
    }

    @Override
    public void withdraw(int amount) {
        this.amount -= amount;
    }

    @Override
    public void deposit(int amount) {
        this.amount += amount;
    }

    public void checkAmount() {
        System.out.println("The amount of money in this account: " + this.amount);
    }

    public void checkAccountInfo() {
        System.out.println("The owner of this account is " + owner);
    }

    public static void main(String[] args) {
        PersonalAccount account = new PersonalAccount("Chaerin");
        account.checkAccountInfo();
        account.deposit(1000);
        account.checkAmount();
        account.withdraw(200);
        account.checkAmount();
    }
}
