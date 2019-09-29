package caseus.neo4j.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Getter
@Setter
@NodeEntity
public class Supplier extends AbstractPersistable<Long> {

    private String companyName;
    @Relationship(type = "SUPPLIES")
    @JsonIgnore
    private List<Product> products;

}
