package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Supplier;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SupplierRepository extends Neo4jRepository<Supplier, Long> {
}
