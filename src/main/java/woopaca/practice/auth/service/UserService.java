package woopaca.practice.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import woopaca.practice.auth.domain.User;
import woopaca.practice.auth.exception.AppException;
import woopaca.practice.auth.exception.ErrorCode;
import woopaca.practice.auth.jwt.JwtUtil;
import woopaca.practice.auth.repository.UserRepository;

import javax.crypto.SecretKey;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

//    @Value("${jwt.secret}")
    private final SecretKey secretKey;

    public String join(String username, String password) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPLICATE, "이미 존재하는 username입니다.");
                });

        woopaca.practice.auth.domain.User user = woopaca.practice.auth.domain.User.builder()
                .username(username)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);

        return "SUCCESS";
    }

    public String signIn(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, "존재하지 않는 회원입니다."));

        if (!encoder.matches(password, user.getPassword())) { // 순서 주의
            throw new AppException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀렸습니다.");
        }

        return JwtUtil.createToken(user.getId(), user.getUsername(), secretKey);
    }
}
