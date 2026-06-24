package practice.thetopics.Module1.Interface;

public class Main {
    public static void main(String[] args) {

        Payable p1 = new CreditCard("Atharv");
        Payable p2 = new UPIpayments();

        p1.processPayment(5000);
        p1.printReceipt();       // uses default method
        p1.refund(1000);

        System.out.println("---");

        p2.processPayment(2000);
        p2.printReceipt();
    }
}

// INTERFACE AUR ABSTRACT JO DELETE KAR DIYA >>>>>>RE VIST THEM
