package com.afamzy.customermgtportal.model;

public class DeleteCustomerRequestModel {
    private String customerName;

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
