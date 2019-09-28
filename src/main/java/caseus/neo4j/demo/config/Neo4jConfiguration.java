package caseus.neo4j.demo.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories("caseus.neo4j.demo.repository")
public class Neo4jConfiguration {

    @Value("${neo4j.uri:http://neo4j:northwind@localhost:7474}")
    private String uri;

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new Builder().uri(uri).credentials("neo4j", "123456").build();
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "caseus.neo4j.demo.entity");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

}
