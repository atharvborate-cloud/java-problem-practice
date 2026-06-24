package practice.thetopics.Module1.Interface;

// Class implementing the interface
public class CreditCard implements Payable {

    String cardHolder;

    public CreditCard(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(cardHolder + " paid ₹" + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("₹" + amount + " refunded to " + cardHolder);
    }
}
