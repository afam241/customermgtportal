package com.afamzy.customermgtportal.dao;


import com.afamzy.customermgtportal.model.*;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    DataSource dataSource;

    //for logging errors where need be
    private final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public SaveCustomerResponse saveCustomer(SaveCustomerRequestModel saveCustomerRequestModel) {
        logger.info("Save Customer Request::: " + saveCustomerRequestModel);  //making use of the logger

        //instatiate your connection coming from java.sql
        Connection connection = null;
        CallableStatement callableStatement = null;
        SaveCustomerResponse saveCustomerResponse = new SaveCustomerResponse();

        //create a try to handle exceptions... so that application dose not crash due to errors
        try{
            connection = dataSource.getConnection();
            String query = "call CUS_MGT_PORTAL.proc_save_customer(?,?,?,?,?,?,?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,saveCustomerRequestModel.getCustomerName());
            callableStatement.setString(2,saveCustomerRequestModel.getPassword());
            callableStatement.setString(3,saveCustomerRequestModel.getAddress());
            callableStatement.setString(4,saveCustomerRequestModel.getDepartment());
            callableStatement.setDouble(5,saveCustomerRequestModel.getNetWorth());
            callableStatement.registerOutParameter(6, Types.VARCHAR);
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            callableStatement.execute();        //telling java to call the prceedures

            saveCustomerResponse.setResponseCode(callableStatement.getString(6));
            saveCustomerResponse.setResponseMessage(callableStatement.getString(7));
        }catch (Exception exception){
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }finally{
            if(connection != null){
                try{
                    connection.close();     //connection needs to be closed so that memory is not used up contineously.. again, another method needs to use the connection thereby making it available
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
            if(callableStatement != null){
                try{
                    callableStatement.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
        logger.info("Save customer response ::: " + saveCustomerResponse);
        return saveCustomerResponse;
    }

    @Override
    public EditCustomerResponse editCustomer(SaveCustomerRequestModel editCustomerRequestModel) {
        logger.info("Edit Customer Request::: " + editCustomerRequestModel);

        Connection connection = null;
        CallableStatement callableStatement = null;
        EditCustomerResponse response = new EditCustomerResponse();

        try {
            //connection = dataSource.getConnection();
            connection = cardOracleDataSource().getConnection();
            String query = "call CUS_MGT_PORTAL.proc_edit_customer(?,?,?,?,?,?,?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,editCustomerRequestModel.getCustomerName());
            callableStatement.setString(2,editCustomerRequestModel.getPassword());
            callableStatement.setString(3,editCustomerRequestModel.getAddress());
            callableStatement.setString(4,editCustomerRequestModel.getDepartment());
            callableStatement.setDouble(5,editCustomerRequestModel.getNetWorth());
            callableStatement.registerOutParameter(6,Types.VARCHAR);
            callableStatement.registerOutParameter(7,Types.VARCHAR);
            callableStatement.execute();

            response.setResponseCode(callableStatement.getString(6));
            response.setResponseMessage(callableStatement.getString(7));

        }catch (Exception exception){
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
            if (callableStatement != null){
                try {
                    callableStatement.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }


        return response;
    }


    public static DataSource cardOracleDataSource(){
        OracleDataSource ds = null;
        try {
            ds = new OracleDataSource();
            ds.setURL("jdbc:oracle:thin:@//localhost:1521/xe");  //connection URL info obtained from database schema properties
            ds.setUser("system");
            ds.setPassword("afam");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }

    /*

        //Test for editing customer
    public static void main(String[] args) {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        SaveCustomerRequestModel edit2 = new SaveCustomerRequestModel("Akeem","6r5dcf","543edx","87ygtf",4556.23);

        EditCustomerResponse edit = customerDao.editCustomer(edit2);
        System.out.println("Response::: " + edit.getResponseCode() + " Message::: " + edit.getResponseMessage());
    }

*/
}


