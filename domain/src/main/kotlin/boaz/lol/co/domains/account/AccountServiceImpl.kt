package boaz.lol.co.domain.account

import boaz.lol.co.application.account.AccountService
import boaz.lol.co.application.account.dto.SignUpReq
import boaz.lol.co.application.account.dto.SignInReq
import boaz.lol.co.application.account.dto.AccountRes
import boaz.lol.co.storage.entity.account.AccountEntity
import boaz.lol.co.domains.account.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    // passwordEncoder, tokenProvider DI 초기화 필요
) : AccountService {

    override fun signUp(reqDto: SignUpReq): AccountRes {
        valSignUp(reqDto)
        val encryptedPassword = passwordEncoder.encode(reqDto.password)
        val newAccount = AccountEntity.create(reqDto, encryptedPassword)
        accountRepository.save(newAccount)
        return newAccount.toAccountRes()
    }

    override fun signIn(reqDto: SignInReq): String {
        val account = valSignIn(reqDto)
        return tokenProvider.createToken(account.email, account.roles)
    }

    // 유효성 검증 메서드
    private fun valSignUp(reqDto: SignUpReq) {
    }

    private fun valSignIn(reqDto: SignInReq): AccountEntity {
        val account = accountRepository.findByEmail(reqDto.email)
            ?: throw IllegalArgumentException("계정을 찾을 수 없습니다.")
        if (!passwordEncoder.matches(reqDto.password, account.password)) {
            throw IllegalArgumentException("인증되지 않은 계정입니다.")
        }
        return account
    }
}
