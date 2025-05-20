package tr.org.ecommerce.domain.model.common;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity implements Serializable {

    protected ID id;

    protected AbstractEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        return id.equals(((AbstractEntity) o).id);
    }

    public void setId(ID id) {
        this.id = id;
    }

    protected void generateId() {
        this.id = ID.create();
    }

}

