package Imanol.ipd.adapter.creditapi.bankx;

/**
 * @author Imanol
 */
public class XBankCreditRequest {
    private String customerName;
    private double requestAmount;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(double requestAmount) {
        this.requestAmount = requestAmount;
    }
}