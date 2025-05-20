package tr.org.ecommerce.domain.model.common;

import tr.org.ecommerce.domain.model.common.util.RandomStringGenerator;

import java.util.Objects;

public class ID {
    private final String id;

    private ID(String id) {
        this.id = id;
    }

    public static ID of(String id) {
        return new ID(id);
    }

    public static ID create() {
        String idString = RandomStringGenerator.generate(12);
        return new ID(idString);
    }

    public String id() {return id;}

    @Override
    public String toString() {
        return "ID{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID id1 = (ID) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

