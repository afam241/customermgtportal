package com.afamzy.customermgtportal.model;

public class OneCustomerRequestModel {
    private String customerName;

    public OneCustomerRequestModel(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "DeleteCustomerRequestModel{" +
                "customerName='" + customerName + '\'' +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
