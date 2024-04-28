package boaz.lol.co.domains.account

import boaz.lol.co.application.account.dto.*
import boaz.lol.co.domains.account.base.Role

interface AccountService {
    // 계정 등록
    // 권한을 별도로 지정하지 않은 경우, 기본적으로 'USER' 권한을 부여.
    fun register(email: String, password: String, role: Role)

    // 사용자 검증 -> 성공시 userIdx 반환
    fun verifyUser(email: String, password: String): Long

    fun getUserInfo(id: Long): AccountRes
}