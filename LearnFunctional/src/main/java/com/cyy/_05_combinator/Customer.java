package com.cyy._05_combinator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

import static com.cyy._05_combinator.CustomerRegistrationValidator.*;

/**
 * @author dachen
 */
@Data
@AllArgsConstructor
@ToString
public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate birthDay;

    public static void main(String[] args) {
        Customer customer = new Customer("Dachen", "380803250@qq.com"
                , "+0123", LocalDate.of(2000, 1, 1));
//        System.out.println(new CustomerValidateService().isCustomerValidate(customer));
        CustomerRegistrationValidator.ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
