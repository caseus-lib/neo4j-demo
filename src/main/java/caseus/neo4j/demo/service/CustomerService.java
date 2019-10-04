package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.Customer;

public interface CustomerService {

    Customer fetch(long id, int depth);

    Customer fetchAny();

}
