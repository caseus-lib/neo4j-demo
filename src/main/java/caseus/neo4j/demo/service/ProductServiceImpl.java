package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.Category;
import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Product;
import caseus.neo4j.demo.repository.CompositeProductRepository;
import caseus.neo4j.demo.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Product> fetch(int year) {
        return productRepository.findByYear(year);
    }

    @Transactional
    @Override
    public void changeCategory(Product product, Category category) {
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public Product fetch(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    @Override
    public void changeProducts(CompositeProduct compositeProduct, List<Product> products) {
        compositeProduct.setProducts(products);
        productRepository.save(compositeProduct);
    }

    @Override
    public CompositeProduct fetchComposite(Long id) {
        return compositeProductRepository.findById(id)
                                         .orElseThrow(RuntimeException::new);
    }

}
