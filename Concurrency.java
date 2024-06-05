public class Concurrency {
    public static void main(String[] args) {
        Thread counterUp = new Thread(new CounterUp());
        Thread counterDown = new Thread(new CounterDown());

        counterUp.start();
        try {
            counterUp.join(); // Wait for counterUp to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterDown.start();
    }
}

class CounterUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Counter Up: " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CounterDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counter Down: " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
