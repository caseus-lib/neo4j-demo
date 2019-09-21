package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.CompositeProduct;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CompositeProductRepository extends Neo4jRepository<CompositeProduct, Long> {
}
