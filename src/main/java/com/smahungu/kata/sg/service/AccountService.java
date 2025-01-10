package com.smahungu.kata.sg.service;

import com.smahungu.kata.sg.model.AccountModel;

public class AccountService {

    public AccountModel deposit(AccountModel accountModel, float amount) {

        accountModel.setBalance(accountModel.getBalance() + amount);

        return accountModel;
    }




}
