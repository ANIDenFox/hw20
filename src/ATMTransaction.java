class ATMTransaction implements Runnable {
    private BankAccount account;
    private boolean isWithdrawal;
    private int amount;

    public ATMTransaction(BankAccount account, boolean isWithdrawal, int amount) {
        this.account = account;
        this.isWithdrawal = isWithdrawal;
        this.amount = amount;
    }

    public void run() {
        if (isWithdrawal) {
            account.withdraw(amount);
        } else {
            account.deposit(amount);
        }
    }
}