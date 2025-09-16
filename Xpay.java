public class Main {
    public static void main(String[] args) {
        // Create an Xpay object
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);

        System.out.println("Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Card Owner Name: " + payD.getCardOwnerName());
        System.out.println("Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());

        // Test setting values through the adapter
        System.out.println("\nTesting setter methods:");
        payD.setCreditCardNo(1234567890123456L);
        payD.setCardOwnerName("John Smith");
        payD.setCardExpMonthYear("12/26");
        payD.setCVVNo(123);
        payD.setTotalAmount(100.50);

        System.out.println("Updated Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Updated Card Owner Name: " + payD.getCardOwnerName());
        System.out.println("Updated Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("Updated CVV: " + payD.getCVVNo());
        System.out.println("Updated Total Amount: " + payD.getTotalAmount());
    }
}
