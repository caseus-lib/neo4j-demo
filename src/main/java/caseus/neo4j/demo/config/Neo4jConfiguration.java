package caseus.neo4j.demo.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
public class Neo4jConfiguration {

    @Value("${neo4j.uri}")
    private String uri;

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new Builder().uri(uri).build();
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(),
                                  "caseus.neo4j.demo.entity");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

}
