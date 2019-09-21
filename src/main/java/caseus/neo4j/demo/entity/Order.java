package caseus.neo4j.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;
import java.util.List;

@NodeEntity
@Getter
@Setter
public class Order extends AbstractPersistable<Long> {

    @DateString("yy-MM-dd")
    private Date date;
    @Relationship(type = "INCLUDES")
    private List<OrderDetails> orderDetails;

}
