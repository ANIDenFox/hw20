class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        balance = initialBalance;
    }

    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Недостатньо коштів!");
        } else {
            balance -= amount;
            System.out.println("Знімається: " + amount + ", Залишок коштів: " + balance);
        }
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Внесено на рахунок: " + amount + ", Новий баланс: " + balance);
    }

    public synchronized int getBalance() {
        return balance;
    }
}