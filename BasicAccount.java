public class BasicAccount implements IBankAccount {
    private int balance; // in cents, always >= 0

    public BasicAccount(int initialCents) {
        this.balance = initialCents;
    }


}
