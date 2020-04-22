package com.assertj;

import com.unittest.customer.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomAssertTest {
    private CustomerRepository customerRepository;
    private NotificationService notificationService;
    private CustomerService customerService;

    public static final String USERNAME = "kader";
    public static final String EMAIL = "k@k.com";
    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
        customerRepository = Mockito.mock(CustomerRepository.class);
        notificationService = Mockito.mock(NotificationService.class);

        customerService.setCustomerRepository(customerRepository);
        customerService.setNotificationService(notificationService);

    }

    @Test
    public void testCustomAssertJUnit() throws Exception{
        Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        Mockito.verify(notificationService).newCustomerMailSend(USERNAME, EMAIL);

        assertNotNull( customer.getGifts());
        assertEquals(2, customer.getGifts().size());
        assertEquals("welcome1", customer.getGifts().get(0).getName());
        assertEquals("welcome2", customer.getGifts().get(1).getName());

    }

    @Test
    public void testCustomAssert() throws Exception {
        Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
        assertThatCustomer(customer)
                .isSaved()
                .hasReceivedWelcomeNotification()
                .hasGift(2)
                .hasGiftWithName("welcome1")
                .hasGiftWithName("welcome2");


    }
    private CustomerAssert assertThatCustomer(Customer customer){
        return  new CustomerAssert(customer, CustomerAssert.class, customerRepository, notificationService);

    }
}
