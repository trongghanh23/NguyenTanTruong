package com.example.demo.dto;

import com.example.demo.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    private String gender;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}", message = "ID number must be 10 numbers")
    private String idCard;

    @Pattern(regexp = "(0|([(]84[)][+]))(9(0|1)[0-9]{7})",
            message = "Please input following 090xxxxxxx or 091xxxxxxx hoặc (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String phoneNumber;

    @Email(message = "please input correct email abc@email")
    private String email;

    private String address;
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.name.matches("^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5} *$")) {
            errors.rejectValue("name", "nameValidation.regex", "Please input name following 'Nguyen Van B'");
        }
    }
}
