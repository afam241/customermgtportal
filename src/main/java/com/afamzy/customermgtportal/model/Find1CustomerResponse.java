package com.afamzy.customermgtportal.model;

import java.util.List;

public class Find1CustomerResponse {
    private String responseCode;
    private String responseMessage;
    private List<CustomerModel> customerModel;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<CustomerModel> getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(List<CustomerModel> customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    public String toString() {
        return "Find1CustomerResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", customerModel=" + customerModel +
                '}';
    }
}
