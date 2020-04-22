package com.unittest.customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryStup extends CustomerRepository {
    private Map<Integer,Customer> customerList = new HashMap<Integer, Customer>();
    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void deleted(Integer customerId) {
        customerList.remove(customerId);
    }

    @Override
    public Customer search(Integer customerId) {
        return customerList.get(customerId);
    }

    public Map<Integer,Customer> getCustomerList(){
        return customerList;
    }

    public void deletedAll() {
        customerList.clear();
    }
}
