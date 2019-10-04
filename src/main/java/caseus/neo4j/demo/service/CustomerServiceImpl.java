package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.Customer;
import caseus.neo4j.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer fetch(long id, int depth) {
        return customerRepository.findById(id, depth)
                                 .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Customer fetchAny() {
        return customerRepository.findAll(0).iterator().next();
    }

}
