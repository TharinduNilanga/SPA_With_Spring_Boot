package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public String generateCustomerId() {
            if (repo.getId()==null){
                String id = repo.getId();
                int newId = Integer.parseInt(id.replace("C", ""));
                return String.format("C%03d",newId+1);
            }else {
                return "C001";
            }

    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!repo.existsById(customerDTO.getId())){
            repo.save(mapper.map(customerDTO, Customer.class));
        }else {
            throw new RuntimeException("Customer is already Exists.....");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("No such Customer is Exists.. please Check the id and TryAgain... ");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
            if (repo.existsById(customerDTO.getId())){
                repo.save(mapper.map(customerDTO,Customer.class));
            }else {
                throw new RuntimeException("Customer Update fails....");
            }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
       if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(),CustomerDTO.class);
       }else{
           throw new RuntimeException("No Customer with"+id);
       }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
