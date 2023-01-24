package woopaca.practice.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woopaca.practice.auth.domain.dto.SignInRequestDTO;
import woopaca.practice.auth.domain.dto.SignUpRequestDTO;
import woopaca.practice.auth.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        userService.join(signUpRequestDTO.getUsername(), signUpRequestDTO.getPassword());
        return ResponseEntity.ok().body("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignInRequestDTO signInRequestDTO) {
        String token = userService.signIn(signInRequestDTO.getUsername(), signInRequestDTO.getPassword());
        return ResponseEntity.ok().body(token);
    }
}
