package boaz.lol.co

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoApplication

fun main(args: Array<String>) {
	runApplication<CoApplication>(*args)
}
