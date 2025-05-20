package tr.org.ecommerce.application.service.impl;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.application.service.spec.LogAppService;
import tr.org.ecommerce.domain.model.log.Log;
import tr.org.ecommerce.domain.port.out.LogRepositoryPort;

import java.util.List;

@Component
public class LogAppServiceImpl implements LogAppService {
    private final LogRepositoryPort logRepositoryPort;

    private LogAppServiceImpl(LogRepositoryPort logRepositoryPort) {
        this.logRepositoryPort = logRepositoryPort;
    }

    @Override
    public void log(String logString){
        System.out.println(">>> LOG: " + logString);
        Log log = Log.of(logString);
        logRepositoryPort.log(log);
    }


}
