package boaz.lol.co.resolver

import boaz.lol.co.domains.account.AccountData
import boaz.lol.co.domains.account.AccountService
import org.springframework.core.MethodParameter
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class AuthAccountDataArgumentResolver (
    private val accountService: AccountService
) : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(AuthAccountData::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): AccountData {
        val annotation: AuthAccountData? = parameter.getMethodAnnotation(AuthAccountData::class.java)
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val principal: Long = authentication.principal as Long

        return accountService.getById(principal).to()
    }

}