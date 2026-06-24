package practice.thetopics.Module1.Interface;

public class UPIpayments implements Payable{


    @Override
    public void processPayment(double amount) {
        System.out.println("UPI payment of ₹" + amount + " successful");
    }

    @Override
    public void refund(double amount) {
        System.out.println("₹" + amount + " refunded via UPI");
    }
}

