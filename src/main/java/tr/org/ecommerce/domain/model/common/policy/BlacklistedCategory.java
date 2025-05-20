package tr.org.ecommerce.domain.model.common.policy;

public enum BlacklistedCategory {
    PATLAYICI("Patlayıcı"),
    UYUSTURUCU("Uyuşturucu"),
    ATESLI_SILAH("Ateşli Silah"),
    RECETELI_ILAC("Reçeteli İlaç");

    private final String categoryName;

    BlacklistedCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static boolean isBlacklisted(String name) {
        for (BlacklistedCategory item : BlacklistedCategory.values()) {
            if (item.getCategoryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
