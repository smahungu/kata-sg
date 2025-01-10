package com.smahungu.kata.sg.service;

import com.smahungu.kata.sg.exception.NoPositiveAmountException;
import com.smahungu.kata.sg.model.AccountModel;

public class AccountService {

    public AccountModel deposit(AccountModel accountModel, float amount) {
        validateDepositAmount(amount);
        accountModel.setBalance(accountModel.getBalance() + amount);
        return accountModel;
    }

    private void validateDepositAmount(float amount) {
        if(amount <= 0.0f) {
            throw new NoPositiveAmountException("The deposit amount must be greater than zero.");
        }
    }


}
