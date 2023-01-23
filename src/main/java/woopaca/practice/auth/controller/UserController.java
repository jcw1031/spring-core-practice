package woopaca.practice.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woopaca.practice.auth.domain.dto.UserSignUpRequestDTO;
import woopaca.practice.auth.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> join(@RequestBody UserSignUpRequestDTO signUpRequestDTO) {
        userService.join(signUpRequestDTO.getUsername(), signUpRequestDTO.getPassword());
        return ResponseEntity.ok().body("회원가입이 완료되었습니다.");
    }
}
