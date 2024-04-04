package boaz.lol.co.account.account

import org.springframework.stereotype.Controller

@Controller
class AccountController(
    private val accountService: AccountService
) {
}