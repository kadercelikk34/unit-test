package com.junit;

import com.unittest.customer.NotificationService;
import com.unittest.customer.exception.MailServerUnavaibleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
public class ExceptionTest {
    private NotificationService notificationService = new NotificationService();
    @Test
    public void testTryCatchException(){
        try {
            notificationService.everyWeekMailSend();

        }catch (Exception ex){
            assertTrue(ex instanceof MailServerUnavaibleException);
            assertEquals("email sender error",ex.getMessage());
        }
    }
    /*Bu metodçalıştığında  MailServerUnavaibleException tipinde bir hata bekliyorum.Hangi hatayı beklediğimiz veririz.
    Dezavantajı hata mesajının ne olduğunu kontol etme olanağı olmamasıdır. */
    @Test(expected = MailServerUnavaibleException.class)
    public void testExpectedException() throws Exception{
        notificationService.everyWeekMailSend();
    }

    //Oluşan hatayı yakalayıp gerekli sorgu yapılır
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    //Beklenen hata ve mesaj önden verilir sonra metod çağrılır ve doğrulu kontrol edilir.
    @Test
    public void testRuleException() throws Exception{
        thrown.expect(MailServerUnavaibleException.class);
        thrown.expectMessage("email sender error");
        notificationService.everyWeekMailSend();
    }

    /*JUnit içeririnde olmayan farklı bir kütüphanedir.
    Bir satırla atılan hatayı yakalamanızı sağlıyor .
    Ardından yakalanna hatayı istediğiniz gibi yakalayıp sorguları gerçekleştirebilirsiniz
    */
    @Test
    public void testCatchExceptionFramework() throws Exception {
        catchException(notificationService).everyWeekMailSend();
        assertTrue(caughtException() instanceof MailServerUnavaibleException);
        assertEquals("email sender error",caughtException().getMessage());
    }
}
