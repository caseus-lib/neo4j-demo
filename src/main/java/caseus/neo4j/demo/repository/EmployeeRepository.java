package caseus.neo4j.demo.repository;

import caseus.neo4j.demo.entity.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
}
