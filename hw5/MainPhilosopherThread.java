import java.util.concurrent.Semaphore;

public class MainPhilosopherThread {
    private static final int numPhilosophers = 5;
    private static final String[] philosopherNames = {"Сократ", "Аристотель", "Ницше", "Кант", "Макиавелли"};

    public static void main(String[] args) {

        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore semaphore = new Semaphore(1); // можно управлять сколько философов едят одновременно

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(philosopherNames[i], semaphore);
            philosophers[i].start();
        }
    }
}
