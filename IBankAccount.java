/**
 * An interface representing a simple bank account with basic operations such as deposit,
 * withdrawal, balance inquiry, bill payment, and fund transfer.
 *
 */
public interface IBankAccount {
    /**
     * Deposits the number of cents into the bank account balance directly. There is no limit.
     * @param cents the amount to deposit
     *
     * @pre cents > 0
     *
     * @post Account = #Account with the account's balance updated to include the cents value.
     */
    void deposit(int cents);

    /**
     * This method will determine the total amount owed by all bills, and confirm that
     * accounts unable to withdrawal can afford to pay. If so, or if the account
     * permits overdraft, then the balance is subtracted for each bill in the array of bills.
     *
     * @param bills a collection of ints to subtract from the account's balance
     *
     * @return true if the bills were successfully paid, false otherwise
     *
     * @pre bills != null AND bills.length > 0 AND forall i: bills[i] > 0
     *
     * @post payBills = true IFF this.withdraw(total) = true AND this.getBalance = #this.getBalance - total,
     * OW payBills = false AND this.getBalance = #this.getBalance
     */
    boolean payBills(int[] bills);

    /**
     * Withdraws the numbers of cents into the account, where should the withdrawal result
     * in the account's balance going negative, the balance remains unchanged, and the
     * method returns false
     *
     * @param cents the amount to withdraw
     *
     * @return true if the withdrawal was successful, false otherwise
     *
     * @pre cents > 0
     *
     * @post withdraw = true IFF getBalance > cents AND getBalance is reduced by cents, OW false AND
     * getBalance = #getBalance
     */
    boolean withdraw(int cents);

    /**
     * Checks to see if the balance is still positive
     *
     * @return false if getBalance is positive, true otherwise
     *
     * @pre none
     *
     * @post isOverdrawn getBalance < 0 AND self = #self
     */
    boolean isOverdrawn();


    /**
     * simple accessor for the balance of the account.
     *
     * @return the balance of this account
     *
     * @pre none
     *
     * getBalance = the balance associated with this account, not always positive as
     * different account types have different rules AND self = #self
     */
    int getBalance();

    /**
     * This method will transfer money from this account to another account.
     *
     * @param other the other account to transfer money to
     * @param cents the amount to transfer
     *
     * @return true if the transfer was successful, false otherwise
     *
     * @pre cents > 0 AND other != null
     *
     * @post transferTo = true IFF this.withdraw(cents) = true AND this.getBalance = #this.getBalance - cents
     * AND other.getBalance = #other.getBalance + cents, OW transferTo = false AND this.getBalance = #this.getBalance
     * AND other.getBalance = #other.getBalance
     */
    boolean transferTo(IBankAccount other, int cents);
}
