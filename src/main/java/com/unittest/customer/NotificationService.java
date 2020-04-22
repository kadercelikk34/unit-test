package com.unittest.customer;

import com.unittest.customer.exception.MailServerUnavaibleException;

public class NotificationService {
    public void newCustomerMailSend(String userName, String email){
        System.out.println("mail send");

    }
    public void everyWeekMailSend(){
        throw new MailServerUnavaibleException("email sender error");

    }
}
