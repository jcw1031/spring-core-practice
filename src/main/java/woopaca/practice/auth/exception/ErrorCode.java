package woopaca.practice.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USERNAME_DUPLICATE(HttpStatus.CONFLICT, "");

    private HttpStatus httpStatus;
    private String message;
}
