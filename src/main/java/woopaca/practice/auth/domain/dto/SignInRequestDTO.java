package woopaca.practice.auth.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequestDTO {

    private String username;
    private String password;

    @Builder
    public SignInRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
