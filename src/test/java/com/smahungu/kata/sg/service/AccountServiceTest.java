package com.smahungu.kata.sg.service;

import com.smahungu.kata.sg.exception.BadWithdrawalAmountException;
import com.smahungu.kata.sg.exception.NoPositiveAmountException;
import com.smahungu.kata.sg.model.AccountModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Test
    void givenAccount_whenDeposit_thenBalanceUpdate() {
        //Given
        AccountModel accountModel = new AccountModel();

        //When
        AccountModel result = accountService.deposit(accountModel, 785.35f);

        //Then
        assertEquals(785.35f, result.getBalance());
    }

    @Test
    void givenAccount_whenNoPositiveAmountDeposit_thenException() {
        //Given
        AccountModel accountModel = new AccountModel();

        //When & Then
        assertThrows(NoPositiveAmountException.class, () -> {accountService.deposit(accountModel, -3f);});
    }

    @Test
    void givenAccount_whenWithdrawal_ThenBalanceUpdate() {
        //Given
        AccountModel accountModel = new AccountModel();
        accountModel.setBalance(50f);

        //When
        AccountModel result = accountService.withdrawal(accountModel, 40f);

        //Then
        assertEquals(50f - 40f, result.getBalance());
    }

    @Test
    void givenAccount_whenBadWithdrawalAmount_thenException() {
        //Given
        AccountModel accountModel = new AccountModel();
        accountModel.setBalance(100f);

        //When & Then
        assertThrows(BadWithdrawalAmountException.class, () -> {accountService.withdrawal(accountModel, 200f);});
    }
}
