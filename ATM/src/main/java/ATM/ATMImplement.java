package ATM;

public class ATMImplement implements ATMInterface{
    UserAccount account = new UserAccount();
    public void viewBalance(){
        System.out.println("Available balance: " + account.getBalance());
    }
    public void withdrawAmount(double withdrawAmount){
        if (withdrawAmount <= account.getBalance()){
            account.setBalance(account.getBalance() - withdrawAmount);
            System.out.println(withdrawAmount + " withdrawn");
        } else {
            System.out.println("Insufficient balance!!");
        }
        account.setWithdrawAmount(withdrawAmount);

    }
    public void depositAmount(double depositAmount ){
        account.setBalance( account.getBalance() + depositAmount);
        System.out.println("Amount deposited successfully!");
        account.setDepositAmount(depositAmount);
    }
    public  void viewMiniStatement(){
        System.out.println("==============================================");
        System.out.println("User Id: 10001");
        System.out.println("DepositAmount: " + account.getDepositAmount());
        System.out.println("Withdrawn amount: " + account.getWithdrawAmount());
        viewBalance();
        System.out.println("==============================================");
        System.out.println("Thank you for collaborating!!");
        System.out.println("==============================================");

    }
}
