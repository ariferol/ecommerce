package tr.org.ecommerce.adapter.out.persistence.adapter;

import org.springframework.stereotype.Component;
import tr.org.ecommerce.domain.model.log.Log;
import tr.org.ecommerce.domain.port.out.LogRepositoryPort;

@Component
public class LogRepositoryPortImpl implements LogRepositoryPort {
    @Override
    public void log(Log log) {
        System.out.println("Basilacak Log nesnesi : " + log.toString());
        /**
         * TO DO : Burada, Seri Log API si kullanılarak, log objesi json olarak belirli bir path e log file
         * olarak kaydedilecek. Yani persist edilecek yer neresiyse(RDB, NoSQLdb,File,) oraya log persist edilecek
         * Log nesnesinin içeriği audit , exception, info logu şeklinde hangi tür olursa olsun istenilen yere persist edilebilir.
         */

    }
}
