package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Customer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRepository extends Neo4jRepository<Customer, Long> {
}
