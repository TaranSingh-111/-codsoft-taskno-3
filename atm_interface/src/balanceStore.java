public class balanceStore {
    private static int balance=1000;
    public static String withdraw(int amount)
    {
        if(amount>balance)
            return "Insufficient balance for withdrawal";
        balance=balance-amount;
        return "Amount of "+amount+" was withdrawn.";
    }
    public static String deposit(int amount)
    {
        balance=balance+amount;
        return "Amount of "+amount+" was deposited.";
    }
    public static String checkBalance()
    {
        return "The Current Balance is: "+balance+".";
    }
}
