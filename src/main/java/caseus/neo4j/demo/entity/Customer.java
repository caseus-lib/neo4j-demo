package caseus.neo4j.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Getter
@Setter
@NodeEntity
public class Customer extends AbstractPersistable<Long> {

    private String name;
    @Relationship(type = "BOUGHT")
    private List<Order> orders;

}
