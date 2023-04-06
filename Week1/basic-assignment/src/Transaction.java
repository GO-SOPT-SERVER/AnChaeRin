//2-5-3 interface
// 2-5-5 generic type
public interface Transaction<T> {
    public abstract void withdraw(T amount);

    public abstract void deposit(T amount);
}
