package com.gmail.yuramitryahin.model.dto;

import com.gmail.yuramitryahin.validate.EmailValidation;
import com.gmail.yuramitryahin.validate.FieldsValueMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword"
)
public class UserRegistrationDto {
    @EmailValidation
    private String email;
    private String password;
    private String repeatPassword;
}
