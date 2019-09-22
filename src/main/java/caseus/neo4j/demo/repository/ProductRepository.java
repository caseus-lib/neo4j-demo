package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product, Long> {

    @Query("MATCH (order:Order)-[:INCLUDES]->(product:Product) " +
            "WHERE date(order.date).year = {year}  " +
            "RETURN collect(product)")
    List<Product> findByYear(@Param("year") int year);

}
