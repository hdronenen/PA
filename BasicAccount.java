public class BasicAccount implements IBankAccount {
    private int balance; // in cents, always >= 0

    public BasicAccount(int initialCents) {
        this.balance = initialCents;
    }


    @Override
    public void deposit(int cents) {
        balance += cents;
    }

    @Override
    public boolean withdraw(int cents) {
        if (balance < cents)
            return false;
        balance -= cents;
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

