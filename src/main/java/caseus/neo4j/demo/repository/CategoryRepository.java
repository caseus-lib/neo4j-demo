package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {
}
