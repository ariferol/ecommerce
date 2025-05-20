package tr.org.ecommerce.domain.port.out;

import tr.org.ecommerce.domain.model.log.Log;

public interface LogRepositoryPort {
    void log(Log log);
}
