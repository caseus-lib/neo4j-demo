package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Order;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface OrderRepository extends Neo4jRepository<Order, Long> {
}
