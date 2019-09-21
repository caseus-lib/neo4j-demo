package caseus.neo4j.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Getter
@Setter
public class Employee extends AbstractPersistable<Long> {

    private String name;
    @Relationship(type = "SOLD")
    private List<Order> orders;
    @Relationship(type = "REPORTS_TO")
    private Employee boss;

}
