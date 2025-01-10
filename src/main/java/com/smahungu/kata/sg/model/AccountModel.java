package com.smahungu.kata.sg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountModel {
    private Long id;
    private float balance;
    private List<OperationModel> operations = new ArrayList<>();

}
