package tr.org.ecommerce.domain.model.common.util;

import java.util.UUID;

public class RandomStringGenerator {

    public static String generate(int length) {
        UUID uuid = UUID.randomUUID();
        String idString = uuid.toString().substring(0, length - 1).replaceAll("_", "");
        return idString;
    }

}
