package woopaca.practice.auth.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {

    @NotEmpty(message = "username은 비어있을 수 없습니다.")
    private String username;
    @NotEmpty(message = "비밀번호는 비어있을 수 없습니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password;
}
