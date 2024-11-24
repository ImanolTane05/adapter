package Imanol.ipd.adapter.impl;

import Imanol.ipd.adapter.creditapi.bankx.XBankCreditAPI;
import Imanol.ipd.adapter.creditapi.bankx.XBankCreditRequest;
import Imanol.ipd.adapter.creditapi.bankx.XBankCreditResponse;

/**
 * @author Imanol
 */
public class XBankCreditAdapter implements IBankAdapter{

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());
        
        XBankCreditAPI api = new XBankCreditAPI();
        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);
        
        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(xresponse.isAproval());
        return response;
    }
}