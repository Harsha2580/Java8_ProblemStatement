package ProductManager;


import java.util.List;
import java.util.Map;

import productsandsku.Product;
import productsandsku.Sku;

public interface ProductManager {
    Map<String, List<Sku>> getActiveProductsAndSkus(List<Product> products, List<Sku> skus);
    List<Product> getActiveProducts(Map<String, List<Sku>> productSkuMap);
    Map<Product, List<Sku>> getFullyActiveProductsAndSkus(List<Product> products, Map<String, List<Sku>> productSkuMap);
}