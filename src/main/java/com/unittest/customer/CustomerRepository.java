package com.unittest.customer;

public class CustomerRepository {
    public void save(Customer customer) {
        System.out.println("Oracle DB custumer save");

    }
    public void deleted(Integer customerId) {
        System.out.println("Oracle DB custumer deleted");

    }
    public Customer search(Integer customerId){
        System.out.println("Oracle DB search");
        return null;
    }


}
