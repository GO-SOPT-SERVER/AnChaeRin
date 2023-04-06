//2-5-3 interface
public interface Transaction<T> {
    public abstract void withdraw(T amount);

    public abstract void deposit(T amount);
}
