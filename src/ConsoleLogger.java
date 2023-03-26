public class ConsoleLogger implements Logger {
    @Override
    public void execute() {
        System.out.println("Заказ выполнен");
    }
}

