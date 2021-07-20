package com.afamzy.customermgtportal.controller;


import com.afamzy.customermgtportal.dao.CustomerDao;
import com.afamzy.customermgtportal.dao.FindAllCustomersResponse;
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

    @PostMapping("/edit")
    public ResponseEntity<EditCustomerResponse> editCustomer(@RequestBody SaveCustomerRequestModel edit){
        EditCustomerResponse response = customerDao.editCustomer(edit);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(@RequestBody OneCustomerRequestModel delete){
        DeleteCustomerResponse response = customerDao.deleteCustomer(delete);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/find1customer")
    public ResponseEntity<Find1CustomerResponse> find1Customer(@RequestBody OneCustomerRequestModel find1){
        Find1CustomerResponse response = customerDao.find1Customer(find1);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findall")
    public ResponseEntity<FindAllCustomersResponse> findAll(){
        FindAllCustomersResponse response = customerDao.findAllCustomers();
        return ResponseEntity.ok(response);
    }
}
