package Imanol.ipd.adapter.impl;

import Imanol.ipd.adapter.creditapi.banky.YBankCreditApprove;
import Imanol.ipd.adapter.creditapi.banky.YBankCreditApproveResult;
import Imanol.ipd.adapter.creditapi.banky.YBankCreditSender;
import Imanol.ipd.adapter.creditapi.banky.YBankCreditSenderListener;

/**
 * @author Imanol
 */
public class YBankCreditAdapter implements IBankAdapter, YBankCreditSenderListener {

    private YBankCreditApproveResult yresponse;

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        YBankCreditApprove yrequest = new YBankCreditApprove();
        yrequest.setCredit((float) request.getAmount());
        yrequest.setName(request.getCustomer());

        YBankCreditSender sender = new YBankCreditSender();
        sender.sendCreditForValidate(yrequest, this);

        do {
            try {
                Thread.sleep(10000);
                System.out.println("yBank request on hold....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (yresponse == null);

        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(yresponse.getApproved() == "Y" ? true : false);
        return response;
    }

    @Override
    public void notifyCreditResult(YBankCreditApproveResult result) {
        this.yresponse = result;
    }
}