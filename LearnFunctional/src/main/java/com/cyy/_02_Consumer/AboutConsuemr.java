package com.yyc.learnfunctionalprograming._02_Consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class AboutConsuemr {
    public static void main(String[] args) {
        Customer daChen = new Customer("daChen", "13820485912");
        printCutsomer(daChen);
        getInformationOfCustomer.accept(daChen);
        getInformationOfCustomerV2.accept(daChen, false);
    }

    static Consumer<Customer> getInformationOfCustomer = customer -> printCutsomer(new Customer("dachen", "13820485912"));

    static BiConsumer<Customer, Boolean> getInformationOfCustomerV2 = (customer,showPhoneNumber) ->{
        System.out.println(customer.getUserName()+" "+(showPhoneNumber ? customer.phoneNumber : "***********"));
    };
    static void printCutsomer(Customer customer) {
        System.out.println(customer.getUserName()+" "+customer.getPhoneNumber());
    }
    static class Customer {
        private final String userName;
        private final String phoneNumber;
        public Customer(String userName, String phoneNumber) {
            this.userName = userName;
            this.phoneNumber = phoneNumber;
        }

        public String getUserName() {
            return userName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
