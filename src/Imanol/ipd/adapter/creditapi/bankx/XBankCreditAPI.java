package Imanol.ipd.adapter.creditapi.bankx;

/**
 * @author Imanol
 */
public class XBankCreditAPI {
    
    public XBankCreditResponse sendCreditRequest(XBankCreditRequest request){
        XBankCreditResponse response =new XBankCreditResponse();
        if(request.getRequestAmount()<= 5000){
            response.setAproval(true);
        }else{
            response.setAproval(false);
        }
        return response;
    }
}