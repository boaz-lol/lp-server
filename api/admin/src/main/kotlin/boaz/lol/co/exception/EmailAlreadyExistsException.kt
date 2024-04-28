package boaz.lol.co.exception

class EmailAlreadyExistsException(email: String) : RuntimeException("이미 존재하는 이메일입니다: $email)")