package boaz.lol.co.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "boaz.lol.co.domains")
@EnableJpaRepositories(basePackages = "boaz.lol.co.domains")
public class CoreJpaConfig {
}
