package com.sprigboot.bankingapp.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
    private String accountType;

}
