package com.smahungu.kata.sg.service;

import com.smahungu.kata.sg.enums.OperationType;
import com.smahungu.kata.sg.exception.BadWithdrawalAmountException;
import com.smahungu.kata.sg.exception.NoPositiveAmountException;
import com.smahungu.kata.sg.model.AccountModel;
import com.smahungu.kata.sg.model.OperationModel;

import java.time.LocalDateTime;

public class AccountService {

    public AccountModel deposit(AccountModel accountModel, float amount) {
        validateDepositAmount(amount);
        accountModel.setBalance(accountModel.getBalance() + amount);
        historize(accountModel, new OperationModel((long)accountModel.getOperations().size(), OperationType.DEPOSIT, amount, amount + accountModel.getBalance(),
                LocalDateTime.now()));
        return accountModel;
    }
    public AccountModel withdrawal(AccountModel accountModel, float amount) {
        validateWithdrawalAmount(accountModel, amount);
        accountModel.setBalance(accountModel.getBalance() - amount);
        historize(accountModel, new OperationModel((long)accountModel.getOperations().size(), OperationType.DEPOSIT, amount, amount + accountModel.getBalance(),
                LocalDateTime.now()));
        return accountModel;
    }


    private void validateDepositAmount(float amount) {
        if(amount <= 0.0f) {
            throw new NoPositiveAmountException("The deposit amount must be greater than zero.");
        }
    }

    private void validateWithdrawalAmount(AccountModel accountModel, float amount) {
        if(amount > accountModel.getBalance()) {
            throw new BadWithdrawalAmountException("The withdrawal amount must be less than the balance.");
        }
    }

    public void historize(AccountModel accountModel, OperationModel operationModel) {
        accountModel.getOperations().add(operationModel);
    }

}
