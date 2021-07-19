package com.afamzy.customermgtportal.model;

public class SaveCustomerRequestModel {
    private String customerName;
    private String password;
    private String address;
    private String department;
    private double netWorth;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    @Override
    public String toString() {
        return "SaveCustomerRequestModel{" +
                "customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", netWorth=" + netWorth +
                '}';
    }
}
