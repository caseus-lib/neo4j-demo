package caseus.neo4j.demo;

import caseus.neo4j.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Neo4jDemoApplicationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
        customerRepository.findById(945L, 2);
    }

}
