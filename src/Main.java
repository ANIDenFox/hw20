public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            if (i % 2 == 0) {
                threads[i] = new Thread(new ATMTransaction(account, true, 200));
            } else {
                threads[i] = new Thread(new ATMTransaction(account, false, 300));
            }
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Баланс: " + account.getBalance());
    }
}