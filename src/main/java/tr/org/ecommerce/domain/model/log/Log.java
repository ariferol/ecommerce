package tr.org.ecommerce.domain.model.log;

import tr.org.ecommerce.domain.model.common.AbstractEntity;
import tr.org.ecommerce.domain.model.common.ID;

import java.time.LocalDateTime;

public class Log extends AbstractEntity {
    private LocalDateTime time;
    private String description;

    private Log(ID id, LocalDateTime time, String description){
        super(id);
        this.time = time;
        this.description = description;
    }

    public static Log of(String description){
        ID id = ID.create();
        LocalDateTime time = LocalDateTime.now();
        return new Log(id, time, description);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", time=" + time +
                ", description='" + description + '\'' +
                '}';
    }
}

