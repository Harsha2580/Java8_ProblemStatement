package ProductManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import productsandsku.Product;
import productsandsku.Sku;

public class ProductManagerImpl implements ProductManager {

    @Override
    public Map<String, List<Sku>> getActiveProductsAndSkus(List<Product> products, List<Sku> skus) {
        Map<String, List<Sku>> productSkuMap = new HashMap<>();
        for (Product product : products) {
            List<Sku> activeSkus = new ArrayList<>();
            for (Sku sku : skus) {
                if (sku.isActive() && sku.getParentProductId().equals(product.getProductId())) {
                    activeSkus.add(sku);
                }
            }
            if (!activeSkus.isEmpty()) {
                productSkuMap.put(product.getProductId(), activeSkus);
            }
        }
        return productSkuMap;
    }

    @Override
    public List<Product> getActiveProducts(Map<String, List<Sku>> productSkuMap) {
        List<Product> activeProducts = new ArrayList<>();
        for (String productId : productSkuMap.keySet()) {
            List<Sku> skus = productSkuMap.get(productId);
            boolean hasActiveSkus = skus.stream().anyMatch(n -> n.isActive());
            if (hasActiveSkus) {
                Product product = new Product(productId, "", null, null, null);
                activeProducts.add(product);
            }
        }
        return activeProducts;
    }

    @Override
    public Map<Product, List<Sku>> getFullyActiveProductsAndSkus(List<Product> products, Map<String, List<Sku>> productSkuMap) {
        Map<Product, List<Sku>> res = new HashMap<>();
        for (Product product : products) {
            List<Sku> skus = productSkuMap.get(product.getProductId());
            if (skus != null && skus.stream().allMatch(n -> n.isActive())) {
                res.put(product, skus);
            }
        }
        return res;
    }
}
