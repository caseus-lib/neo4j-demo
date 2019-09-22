package caseus.neo4j.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ShipperRepository extends Neo4jRepository<ShipperRepository, Long> {
}
