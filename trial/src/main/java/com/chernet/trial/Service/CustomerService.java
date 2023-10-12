package com.chernet.trial.Service;

import com.chernet.trial.dao.CustomerDao;
import com.chernet.trial.exception.CustomerNotFoundException;
import com.chernet.trial.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    private int customerCount = 1;

    public Customer addCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerId){
//        return customerDao.findById(customerId).get();
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer is not found ...");
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerDao.deleteById(customerId);
    }
}
