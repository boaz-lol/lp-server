package boaz.lol.co.application.account

import boaz.lol.co.domains.account.AccountService
import org.springframework.stereotype.Controller

@Controller
class AccountController(
    private val accountService: AccountService
) {
}