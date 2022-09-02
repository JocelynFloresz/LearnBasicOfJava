package com.yyc.learnfunctionalprograming._05_combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.yyc.learnfunctionalprograming._05_combinator.CustomerRegistrationValidator.*;
import static com.yyc.learnfunctionalprograming._05_combinator.CustomerRegistrationValidator.ValidationResult.*;

/**
 * @author dachen
 */
public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    enum ValidationResult {
        SUCCESS, PHONE_NUMBER_NOT_VALID, EMAIL_NOT_VALID, IS_NOT_AN_ADULT
    }

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail()
                .contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber()
                .startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getBirthDay(), LocalDate.now())
                .getYears() > 16 ? SUCCESS : EMAIL_NOT_VALID;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

}
