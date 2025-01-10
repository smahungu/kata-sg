package com.smahungu.kata.sg.model;

import com.smahungu.kata.sg.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperationModel {
    private Long id;
    private OperationType type;
    private float amount;
    private float balance;
    private LocalDateTime date;
}
