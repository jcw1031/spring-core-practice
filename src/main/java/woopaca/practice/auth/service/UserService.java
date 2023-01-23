package woopaca.practice.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woopaca.practice.auth.domain.User;
import woopaca.practice.auth.exception.AppException;
import woopaca.practice.auth.exception.ErrorCode;
import woopaca.practice.auth.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(String username, String password) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPLICATE, "이미 존재하는 username입니다.");
                });

        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        userRepository.save(user);

        return "SUCCESS";
    }
}
