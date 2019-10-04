package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Product;

public interface ProductService {

    Product fetch(Long id);

    CompositeProduct fetchComposite(Long id);

    CompositeProduct fetchAnyComposite();

}
