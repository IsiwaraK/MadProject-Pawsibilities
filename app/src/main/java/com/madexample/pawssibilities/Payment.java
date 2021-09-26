package com.madexample.pawssibilities;

public class Payment {
    private String  NameOnCard;
    private String CardNumber;
    private String ExpDate;
    private String cvv;
    private String MobileNo;

    public Payment(){}
    public Payment(String NameOnCard, String CardNumber, String ExpDate, String cvv, String MobileNo) {
        this.NameOnCard = NameOnCard;
        this.CardNumber = CardNumber;
        this.ExpDate = ExpDate;
        this.cvv = cvv;
        this.MobileNo = MobileNo;
    }
    public String getNameOnCard() {
        return NameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        NameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

}
