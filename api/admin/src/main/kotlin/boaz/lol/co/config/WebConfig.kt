package boaz.lol.co.config

import boaz.lol.co.resolver.AuthAccountDataArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebConfig (
    private val authAccountArgumentResolver: AuthAccountDataArgumentResolver
): WebMvcConfigurer {
    @Override
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(authAccountArgumentResolver)
    }
}