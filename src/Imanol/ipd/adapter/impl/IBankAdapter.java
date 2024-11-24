package Imanol.ipd.adapter.impl;

/**
 * @author Imanol
 */
public interface IBankAdapter {
    public BankCreditResponse sendCreditRequest(BankCreditRequest request);
}