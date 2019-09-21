package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product, Long> {
}
