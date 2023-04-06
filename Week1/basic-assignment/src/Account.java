public class Account implements Transaction {
    private int amount;

    @Override
    public void withdraw(int amount) {
        this.amount -= amount;
    }

    @Override
    public void deposit(int amount) {
        this.amount += amount;
    }

    public void checkAmount() {
        System.out.println("The amount of money in this account: " + amount);
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000);
        account.checkAmount();
        account.withdraw(200);
        account.checkAmount();
    }
}
