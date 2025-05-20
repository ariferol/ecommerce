package tr.org.ecommerce.domain.model.common.policy;

public enum BlacklistedProduct {
    DINAMIT("Dinamit"),
    EROIN("Eroin"),
    ESRAR("Esrar"),
    KOKAIN("Kokain");

    private final String productName;

    BlacklistedProduct(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public static boolean isBlacklisted(String name) {
        for (BlacklistedProduct item : BlacklistedProduct.values()) {
            if (item.getProductName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
