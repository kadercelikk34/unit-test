package com.assertj;

import com.unittest.customer.Customer;
import com.unittest.customer.CustomerRepository;
import com.unittest.customer.NotificationService;
import org.assertj.core.api.AbstractAssert;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.assertj.core.api.Assertions.assertThat;

public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {
    private CustomerRepository customerRepository;
    private NotificationService notificationService;

    public CustomerAssert(Customer customer, Class<?> selfType, CustomerRepository customerRepository, NotificationService notificationService) {
        super(customer, selfType);
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
        isNotNull();
    }

    public CustomerAssert hasGift(int sizeOfGifts) {
        assertThat(actual.getGifts())
                .isNotEmpty()
                .hasSize(sizeOfGifts);
        return this;
    }


    public CustomerAssert hasGiftWithName(String giftName) {
        assertThat(actual.getGifts())
                .isNotEmpty()
                .extracting("name")
                .contains(giftName);
        return this;
    }

    public CustomerAssert isSaved() {
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        return this;

    }

    public CustomerAssert hasReceivedWelcomeNotification() {
        Mockito.verify(notificationService).newCustomerMailSend(CustomAssertTest.USERNAME,CustomAssertTest.EMAIL);
        return this;
    }
}
