package caseus.neo4j.demo.controller;

import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Customer;
import caseus.neo4j.demo.entity.Product;
import caseus.neo4j.demo.repository.CategoryRepository;
import caseus.neo4j.demo.repository.CompositeProductRepository;
import caseus.neo4j.demo.repository.CustomerRepository;
import caseus.neo4j.demo.repository.ProductRepository;
import caseus.neo4j.demo.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class DemoController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CompositeProductRepository compositeProductRepository;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    public DemoController(CustomerRepository customerRepository,
                          ProductRepository productRepository,
                          CompositeProductRepository compositeProductRepository,
                          ProductService productService,
                          CategoryRepository categoryRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.compositeProductRepository = compositeProductRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "customer")
    public Customer fetch() {
        return customerRepository.findById(945L).get();
    }

    @RequestMapping(value = "customer/orders")
    public Customer fetchWithOrders() {
        return customerRepository.findById(945L, 2).get();
    }

    @RequestMapping(value = "customer/orders/products")
    public Customer fetchWithOrdersAndProducts() {
        return customerRepository.findById(945L, 3).get();
    }

    @RequestMapping(value = "customer/only")
    public Customer fetchOnly() {
        return customerRepository.findById(945L, 0).get();
    }

    @RequestMapping(value = "product")
    public Product fetchProduct() {
        return productRepository.findById(62L).get();
    }

    @RequestMapping(value = "product/composite/{id}")
    public CompositeProduct fetchCompositeProduct(@PathVariable("id") Long id) {
        return productService.fetchComposite(id);
    }

    @RequestMapping("product/change/{id}")
    public Product clearCategory(@PathVariable("id") Long id) {
        CompositeProduct product = productService.fetchComposite(id);
        List<Product> products = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                                              .collect(Collectors.toList());
        Collections.shuffle(products);
        productService.changeProducts(product, Arrays.asList(products.get(0), products.get(1), products.get(2)));
        return productService.fetchComposite(id);
    }

}
