package boaz.lol.co.resolver

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class AuthAccountData(val required: Boolean = true)
