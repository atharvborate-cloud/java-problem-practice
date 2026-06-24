package practice.thetopics.Module1.encapsulaton;

public class Bankacc {
    private String accholder ;
    private String AccNumber ;
    private double AccBalance ;
    private int pin;


    public Bankacc(String accholder, String AccNumber, double AccBalance , int pin){
        this.accholder = accholder;
        this.AccNumber = AccNumber;
        setAccBal(AccBalance);
        setPin(pin);

    }

    public String getAccholder() { return accholder; }
    public String getAccNumber() { return AccNumber; }
    public double getAccBalance() { return AccBalance;}



    public void setAccBal(double amount) {
        if(amount < 0 ){
            System.out.println("Negative balance ");
            return;
        }
        this.AccBalance = amount;
    }

    public void setPin(int pin) {
        if(pin <1000 || pin > 9999){
            System.out.println("Invalid pin");
            return;
        }
        this.pin = pin;
    }

    public void deposit ( double amount ){
        if( amount <= 0 ){
            System.out.println("Deposit amount must be greater than zero");
            return;
        }
        this.AccBalance = AccBalance + amount ;
        System.out.println("Deposit amount :" + amount + "| New balance :" + AccBalance);

    }

    public void withdraw ( double amount , int pin ){
        if (pin != this.pin){
            System.out.println("Wron gpin !! Transaction canclled ");
            return;
        }
        if (amount > AccBalance){
            System.out.println("Insufficient Balance ");
            return;
        }
        this.AccBalance = AccBalance - amount;
        System.out.println("Withdrawn amount :"+ amount + " | New Balance :" + AccBalance);

    }
    public void displayAccount (){
        System.out.println(accholder);
        System.out.println(getAccBalance());
        System.out.println(getAccNumber());


    }


    public static void main(String[] args) {
        Bankacc b = new Bankacc("Atharv", "SBI4114", 250000, 4114);
        b.withdraw(1000, 9999);      // wrong pin test
        b.withdraw(999999, 4114);    // overdraft test
        b.deposit(5000);             // valid deposit
        b.withdraw(10000, 4114);     // valid withdrawal
        b.displayAccount();          // final state


    }



}
