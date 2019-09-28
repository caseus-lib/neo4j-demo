package caseus.neo4j.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Getter
@Setter
@RelationshipEntity(type = "INCLUDES")
public class OrderDetails extends AbstractPersistable<Long> {

    private Long amount;
    @StartNode
    private Order order;
    @EndNode
    private Product product;

}
