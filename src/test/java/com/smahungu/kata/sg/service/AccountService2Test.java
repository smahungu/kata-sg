package com.smahungu.kata.sg.service;

import com.smahungu.kata.sg.enums.OperationType;
import com.smahungu.kata.sg.model.AccountModel;
import com.smahungu.kata.sg.model.CustomerModel;
import com.smahungu.kata.sg.model.OperationModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AccountService2Test {

    @InjectMocks
    private AccountService accountService;

    @Test
    void statement_printing_test() {
        CustomerModel customerModel = new CustomerModel();
        assertNull(customerModel.getAccount());

        AccountModel accountModel = new AccountModel();
        customerModel.setAccount(accountModel);
        assertNotNull(customerModel.getAccount());

        OperationModel operationModel11 = new OperationModel(1L, OperationType.DEPOSIT, 100.00f, 100.00f, LocalDateTime.now());
        OperationModel operationModel12 = new OperationModel(2L, OperationType.WITHDRAWAL, 50.00f, 50.00f, LocalDateTime.now());
        OperationModel operationModel13 = new OperationModel(3L, OperationType.DEPOSIT, 100.00f, 150.00f, LocalDateTime.now());

        accountService.historize(accountModel, operationModel11);
        accountService.historize(accountModel, operationModel12);
        accountService.historize(accountModel, operationModel13);

        log.info(customerModel.toString());

    }
}
