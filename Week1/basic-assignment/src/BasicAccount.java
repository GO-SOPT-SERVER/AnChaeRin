//2-5-4 abstract class

public abstract class BasicAccount {
    String accountId;
    int amount;

    public abstract void withdraw(int amount);

    public abstract void deposit(int amount);
}
