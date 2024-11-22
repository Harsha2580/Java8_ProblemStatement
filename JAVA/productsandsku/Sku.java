package productsandsku;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Sku {
    private String skuId;
    private String skuName;
    private String color;
    private LocalDate startDate;
    private LocalDate endDate;
    private String parentProductId;

    public Sku(String skuId, String skuName, String color, LocalDate startDate, LocalDate endDate, String parentProductId) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.color = color;
        this.startDate = startDate;
        this.endDate = endDate;
        this.parentProductId = parentProductId;
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return (startDate.isBefore(today) || startDate.isEqual(today)) && (endDate.isAfter(today) || endDate.isEqual(today));
    }

    public String getParentProductId() {
        return parentProductId;
    }

    @Override
    public String toString() {
        return "Sku [skuId=" + skuId + ", skuName=" + skuName + ", color=" + color + ", startDate=" + startDate
                + ", endDate=" + endDate + ", parentProductId=" + parentProductId + "]";
    }

    
}
