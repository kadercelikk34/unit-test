package com.unittest.customer;

import com.unittest.assertj.Gift;

public class CustomerService {

    private CustomerRepository customerRepository;
    private NotificationService notificationService;

    public Customer handleNewCustomer(String customerName, String email){
        Customer customer = new Customer(customerName, email);

        giveWelcomeGifts(customer);
        customerRepository.save(customer);
        notificationService.newCustomerMailSend(customerName, email);

        return customer;
    }

    private void giveWelcomeGifts(Customer customer) {
        customer.addGift(new Gift("welcome1"));
        customer.addGift(new Gift("welcome2"));

    }

    public void customerDeleted(Integer customerId){
        customerRepository.deleted(customerId);
    }
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


}
