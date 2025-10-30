public class OverdraftAccount implements IBankAccount {
    private int balance;          // in cents (can be negative)
    private final int overdraftLimit; // positive number of cents allowed below 0

    public OverdraftAccount(int initialCents, int overdraftLimit) {
        this.balance = initialCents;
        this.overdraftLimit = overdraftLimit;
    }

}
