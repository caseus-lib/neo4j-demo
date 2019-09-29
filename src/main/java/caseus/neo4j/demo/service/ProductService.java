package caseus.neo4j.demo.service;

import caseus.neo4j.demo.entity.Category;
import caseus.neo4j.demo.entity.CompositeProduct;
import caseus.neo4j.demo.entity.Product;

import java.util.List;

/**
 * Сервис для работы с продуктами
 */
public interface ProductService {

    /**
     * Получить продукты, проданные в заданный год
     *
     * @param year год
     * @return список продуктов
     */
    List<Product> fetch(int year);

    void changeCategory(Product product, Category category);

    Product fetch(Long id);

    void changeProducts(CompositeProduct compositeProduct, List<Product> products);

    CompositeProduct fetchComposite(Long id);

}
