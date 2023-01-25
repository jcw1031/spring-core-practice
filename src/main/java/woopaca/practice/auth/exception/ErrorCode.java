package woopaca.practice.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USERNAME_DUPLICATE(HttpStatus.CONFLICT, "이미 존재하는 username입니다."),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다.");

    private HttpStatus httpStatus;
    private String message;
}
