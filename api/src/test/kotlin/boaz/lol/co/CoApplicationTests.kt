package boaz.lol.co

import boaz.lol.co.domains.account.AccountRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class CoApplicationTests (
	@Autowired private val context: ApplicationContext
) {


	@Test
	fun contextLoads() {
		val beanNames = context.beanDefinitionNames
		beanNames.forEach { println(it) }
	}

	@Test
	fun isAccountRepositoryRegistered() {
		val accountRepository = context.getBean(AccountRepository::class.java)
		// assertNotNull(accountRepository)
		println(accountRepository)
	}

}
