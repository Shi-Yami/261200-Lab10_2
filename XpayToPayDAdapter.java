public class XpayToPayDAdapter implements PayD {
    private final Xpay xpay;

    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
    }

    @Override
    public long getCreditCardNo() {
        return Long.parseLong(xpay.getCreditCardNo());
    }

    @Override
    public void setCreditCardNo(long creditCardNo) {
        xpay.setCreditCardNo(String.valueOf(creditCardNo));
    }

    @Override
    public String getCardOwnerName() {
        return xpay.getCustomerName();
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public String getCardExpMonthYear() {
        return xpay.getCardExpMonth() + "/" + xpay.getCardExpYear();
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        String[] parts = cardExpMonthYear.split("/");
        if (parts.length == 2) {
            xpay.setCardExpMonth(parts[0]);
            xpay.setCardExpYear(parts[1]);
        } else {
            throw new IllegalArgumentException("Expiry date must be in MM/YY format");
        }
    }

    @Override
    public Integer getCVVNo() {
        return xpay.getCardCVVNo() != null ? xpay.getCardCVVNo().intValue() : null;
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        xpay.setCardCVVNo(cVVNo != null ? cVVNo.shortValue() : null);
    }

    @Override
    public Double getTotalAmount() {
        return xpay.getAmount();
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        xpay.setAmount(totalAmount);
    }
}
