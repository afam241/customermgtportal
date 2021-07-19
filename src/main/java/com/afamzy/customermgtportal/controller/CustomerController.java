package com.afamzy.customermgtportal.controller;


import com.afamzy.customermgtportal.dao.CustomerDao;
import com.afamzy.customermgtportal.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/savecustomer")
    public ResponseEntity<SaveCustomerResponse> saveCustomer(@RequestBody SaveCustomerRequestModel model){
        SaveCustomerResponse saveResponse = customerDao.saveCustomer(model);
        return ResponseEntity.ok(saveResponse);
    }

}
