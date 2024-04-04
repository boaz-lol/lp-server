package boaz.lol.co.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["boaz.lol.co.entity"])
@EnableJpaRepositories(basePackages = ["boaz.lol.co.entity"])
internal class CoreJpaConfig