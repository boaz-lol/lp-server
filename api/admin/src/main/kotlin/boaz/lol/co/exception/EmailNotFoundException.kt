package boaz.lol.co.exception

class EmailNotFoundException(email: String) : RuntimeException("해당 이메일을 가진 사용자를 찾을 수 없습니다: $email") {
}