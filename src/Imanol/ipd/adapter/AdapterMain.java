package Imanol.ipd.adapter;

import Imanol.ipd.adapter.impl.BankCreditRequest;
import Imanol.ipd.adapter.impl.BankCreditResponse;
import Imanol.ipd.adapter.impl.IBankAdapter;
import Imanol.ipd.adapter.impl.XBankCreditAdapter;
import Imanol.ipd.adapter.impl.YBankCreditAdapter;

/**
 * @author Imanol
 */
public class AdapterMain {

    public static void main(String[] args) {
        //Generic request for the two API's
        BankCreditRequest request = new BankCreditRequest();
        request.setCustomer("Oscar Blancarte");
        request.setAmount(1000);

        IBankAdapter xBank = new XBankCreditAdapter();
        BankCreditResponse xresponse = xBank.sendCreditRequest(request);
        System.out.println("xBank approved > " + xresponse.isApproved() + "\n");

        IBankAdapter yBank = new YBankCreditAdapter();
        BankCreditResponse yresponse = yBank.sendCreditRequest(request);
        System.out.println("yBank approved > " + yresponse.isApproved() + "\n");

        if (xresponse.isApproved()) {
            System.out.println("xBank approved your credit, congratulations!!");
        } else if (yresponse.isApproved()) {
            System.out.println("yBank approved your credit, congratulations!!");
        } else {
            System.out.println("Sorry your credit has not been approved");
        }
    }
}