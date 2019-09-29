package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Customer;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends Neo4jRepository<Customer, Long> {

    @Query("MATCH (customer:Customer)-[:BOUGHT]->(order:Order) " +
            "WHERE id(order) = {orderId} " +
            "RETURN customer")
    Optional<Customer> findByOrderId(@Param("orderId") Long orderId);

    Optional<Customer> findByName(String name);

}
