package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;

import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
public interface CustomerService {
    String generateCustomerId();
    void  saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO customerDTO);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
