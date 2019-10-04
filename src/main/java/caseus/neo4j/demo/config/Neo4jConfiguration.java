package caseus.neo4j.demo.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("caseus.neo4j.demo.repository")
@EnableTransactionManagement
public class Neo4jConfiguration {

    @Value("${neo4j.uri}")
    private String uri;
    @Value("${neo4j.login}")
    private String login;
    @Value("${neo4j.password}")
    private String password;

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new Builder().uri(uri)
                            .credentials(login, password)
                            .build();
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
