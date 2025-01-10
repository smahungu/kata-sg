package com.smahungu.kata.sg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerModel {
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private AccountModel account;
}
