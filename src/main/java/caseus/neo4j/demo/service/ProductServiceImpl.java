package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Product;
import caseus.neo4j.demo.repository.CompositeProductRepository;
import caseus.neo4j.demo.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Lazy
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CompositeProductRepository compositeProductRepository;

    public ProductServiceImpl(ProductRepository productRepository, CompositeProductRepository compositeProductRepository) {
        this.productRepository = productRepository;
        this.compositeProductRepository = compositeProductRepository;
    }

    @Override
    public Product fetch(Long id) {
        return productRepository.findById(id)
                                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public CompositeProduct fetchComposite(Long id) {
        return compositeProductRepository.findById(id)
                                         .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public CompositeProduct fetchAnyComposite() {
        return compositeProductRepository.findAll().iterator().next();
    }

}
