import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private final String name;
    private final Semaphore eatingSemaphore;

    /**
     * Конструктор класса Philosopher.
     *
     * @param name           Имя философа.
     * @param eatingSemaphore Семафор для управления доступом к столу (или обеду) как в нашей задаче
     */
    public Philosopher(String name, Semaphore eatingSemaphore) {
        this.name = name;
        this.eatingSemaphore = eatingSemaphore;
    }

    /**
     * Метод run, выполняющийся при запуске потока.
     * Философ выполняет 3 обеда, чередуя их с размышлениями.
     */
    @Override
    public void run() {
        int dinners = 3;
        for (int meal = 0; meal < dinners; meal++) {
            try {
                eat();
                think();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }

    /**
     * Метод, представляющий процесс обеда философа.
     * Философ приобретает семафор, обедает, засыпает на 500мил\с, затем освобождает семафор.
     *
     * @throws InterruptedException Если поток был прерван.
     */
    private void eat() throws InterruptedException {
        eatingSemaphore.acquire();
        System.out.println(name + " обедает");
        Thread.sleep(500);
        System.out.println(name + " закончил обедать");
        eatingSemaphore.release();
    }

    /**
     * Метод, представляющий процесс размышления философа на 100мил\с.
     *
     *
     * @throws InterruptedException Если поток был прерван.
     */
    private void think() throws InterruptedException {
        System.out.println(name + " размышляет");
        Thread.sleep(100);
    }
}

