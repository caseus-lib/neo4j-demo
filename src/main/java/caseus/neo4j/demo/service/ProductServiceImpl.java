package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.Product;
import caseus.neo4j.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> fetch(int year) {
        return productRepository.findByYear(year);
    }

}
