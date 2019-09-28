package caseus.neo4j.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@Getter
@Setter
@NodeEntity
public class Product extends AbstractPersistable<Long> {

    private String name;
    @Relationship(type = "IS_IN")
    private Category category;
    @Relationship(type = "SUPPLIES", direction = INCOMING)
    private Supplier supplier;

}
