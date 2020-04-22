package com.unittest.customer;

import com.unittest.assertj.Gift;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer id;
    private String userName;
    private String email;
    private List<Gift> gifts = new ArrayList<Gift>();

    public void addGift(Gift gift){
        gifts.add(gift);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
