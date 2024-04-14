package boaz.lol.co.application.account

import org.springframework.stereotype.Controller

@Controller
class AccountController(
    private val accountService: AccountService
) {
}