package com.cyy._05_combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidateService {
    Boolean emailValidator(String email) {
        return email.contains("@");
    }

    Boolean phoneNumberValidator(String number) {
        return number.startsWith("+0");
    }

    Boolean isAdult(LocalDate age) {
        return Period.between(age, LocalDate.now()).getYears() > 16;
    }

    Boolean isCustomerValidate(Customer customer) {
        return emailValidator(customer.getEmail())
                && phoneNumberValidator(customer.getPhoneNumber())
                && isAdult(customer.getBirthDay());
    }
}
