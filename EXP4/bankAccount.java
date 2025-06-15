class details{
    private double balance;

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount successfully added");
        }
        else{
            System.out.println("please enter valid amount");
        }
    }
    
    protected void withdraw(double amount){
        balance-=amount;
        System.out.println("withdrawl successfull");
    }
    
    void checkbalance(){
        System.out.println("current balance = "+balance);
    }
}

class bankAccount{
    public static void main(String[] args){
        
        details bnk=new details();
        bnk.deposit(100000);
        bnk.withdraw(10000);
        bnk.checkbalance();
    }
}