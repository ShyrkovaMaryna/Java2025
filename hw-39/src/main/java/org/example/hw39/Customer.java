package org.example.hw39;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String socialSecurityNumber;

}