package ProductController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ProductManager.ProductManagerImpl;
import productsandsku.Product;
import productsandsku.Sku;

public class ProductController {

    public static void main(String[] args) {
        ProductManagerImpl productManager = new ProductManagerImpl();

        List<Product> products = Arrays.asList(
            new Product("P1", "Product1", LocalDate.of(2023, 5, 12), LocalDate.of(2025, 8, 7), Arrays.asList("S1", "S2")),
            new Product("P2", "Product2", LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 24), Arrays.asList("S3"))
        );

        List<Sku> skus = Arrays.asList(
            new Sku("S1", "Sku1", "Red", LocalDate.of(2023, 4, 17), LocalDate.of(2024, 12, 20), "P1"),
            new Sku("S2", "Sku2", "Blue", LocalDate.of(2023, 2, 27), LocalDate.of(2025, 6, 28), "P1"),
            new Sku("S3", "Sku3", "Green", LocalDate.of(2023, 9, 4), LocalDate.of(2023, 5, 14), "P2")
        );

        Map<String, List<Sku>> activeProductsAndSkus = productManager.getActiveProductsAndSkus(products, skus);
        List<Product> activeProducts = productManager.getActiveProducts(activeProductsAndSkus);
        Map<Product, List<Sku>> fullyActiveProductsAndSkus = productManager.getFullyActiveProductsAndSkus(products, activeProductsAndSkus);

        System.out.println("Active Products and Skus: " + activeProductsAndSkus);
        System.out.println();
        System.out.println("Active Products: " + activeProducts);
        System.out.println();
        System.out.println("Fully Active Products and Skus: " + fullyActiveProductsAndSkus);
    }
}
