package caseus.neo4j.demo.controller;

import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Customer;
import caseus.neo4j.demo.entity.Product;
import caseus.neo4j.demo.service.CustomerService;
import caseus.neo4j.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final CustomerService customerService;
    private final ProductService productService;

    public DemoController(CustomerService customerService,
                          ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @ApiOperation("Fetch any customer")
    @GetMapping("customer/any")
    public Customer fetchCustomer() {
        return customerService.fetchAny();
    }

    @ApiOperation("Fetch customer from graph with particular depth")
    @GetMapping("customer/{id}/{depth}")
    public Customer fetchCustomer(@PathVariable("id") Long id,
                                  @ApiParam("Persistence horizon") @PathVariable("depth") Integer depth) {
        return customerService.fetch(id, depth);
    }

    @ApiOperation("Fetch any composite product from graph")
    @GetMapping("product/composite/any")
    public CompositeProduct fetchCompositeProduct() {
        return productService.fetchAnyComposite();
    }

    @ApiOperation("Fetch product from graph")
    @GetMapping("product/{id}")
    public Product fetchProduct(@PathVariable("id") Long id) {
        return productService.fetch(id);
    }

    @ApiOperation("Fetch composite product from graph")
    @GetMapping("product/composite/{id}")
    public CompositeProduct fetchCompositeProduct(@PathVariable("id") Long id) {
        return productService.fetchComposite(id);
    }

}
