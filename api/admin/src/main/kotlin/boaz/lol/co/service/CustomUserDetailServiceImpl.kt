package boaz.lol.co.service

import boaz.lol.co.domains.account.AccountRepository
import boaz.lol.co.exception.*
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        val account = accountRepository.findByEmail(username).orElseThrow {
            UsernameNotFoundException("해당 이메일을 가진 사용자를 찾을 수 없음: $username")
        }

        return User.withUsername(account.email)
            .password(account.password)
            .authorities(account.role.toString())
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build().also {
            }
    }

    fun changePassword(email: String, oldPassword: String, newPassword: String) {
        val user = accountRepository.findByEmail(email).orElseThrow {
            EmailNotFoundException("해당 이메일을 가진 사용자를 찾을 수 없음: $email")
        }

        if (!passwordEncoder.matches(oldPassword, user.password)) {
            throw IllegalArgumentException("기존 비밀번호가 일치하지 않습니다.")
        }

        user.password = passwordEncoder.encode(newPassword)
        accountRepository.save(user)
    }
}
