package com.afamzy.customermgtportal.dao;


import com.afamzy.customermgtportal.model.*;
import org.springframework.stereotype.Repository;

@Repository //tell spring to communicate to the database via the data-access-layer (dao)
public interface CustomerDao {
    /*
    define a Response class to showcase the response messages  & a Request class to collect data(POJO) from to be used
    */

    SaveCustomerResponse saveCustomer(SaveCustomerRequestModel saveCustomerRequestModel);
    EditCustomerResponse editCustomer(SaveCustomerRequestModel editCustomerRequestModel);
    DeleteCustomerResponse deleteCustomer(DeleteCustomerRequestModel deleteCustomer);

}
