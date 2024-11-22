package productsandsku;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
public class Product {
    
    private String productId;
    private String productName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> skuIds;

    public Product(String productId, String productName, LocalDate startDate, LocalDate endDate, List<String> skuIds) {
        this.productId = productId;
        this.productName = productName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.skuIds = skuIds;
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return (startDate.isBefore(today) || startDate.isEqual(today)) && (endDate.isAfter(today) || endDate.isEqual(today));
    }

    public String getProductId() {
        return productId;
    }

    public List<String> getSkuIds() {
        return skuIds;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", startDate=" + startDate
                + ", endDate=" + endDate + ", skuIds=" + skuIds + "]";
    }
    
}
