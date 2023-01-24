package woopaca.practice.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import woopaca.practice.auth.domain.dto.SignInRequestDTO;
import woopaca.practice.auth.domain.dto.SignUpRequestDTO;
import woopaca.practice.auth.exception.AppException;
import woopaca.practice.auth.exception.ErrorCode;
import woopaca.practice.auth.service.UserService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("회원가입 성공")
    @WithMockUser
    void signUpSuccess() throws Exception {
        String username = "woopaca";
        String password = "woopaca";

        mockMvc.perform(post("/api/v1/users/sign-up")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new SignUpRequestDTO(username, password))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패 - username 중복")
    @WithMockUser
    void signUpFail() throws Exception {
        String username = "woopaca";
        String password = "woopaca";

        when(userService.join(any(), any()))
                .thenThrow(new RuntimeException("이미 존재하는 username입니다."));

        mockMvc.perform(post("/api/v1/users/sign-up")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new SignInRequestDTO(username, password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("로그인 성공")
    @WithMockUser
    void loginSuccess() throws Exception {
        String username = "woopaca";
        String password = "woopaca";

        when(userService.signIn(any(), any()))
                .thenReturn("token");

        mockMvc.perform(post("/api/v1/users/sign-in")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new SignInRequestDTO(username, password))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 실패 - username 없음")
    @WithMockUser
    void loginFailUsername() throws Exception {
        String username = "woopaca";
        String password = "woopaca";

        when(userService.signIn(any(), any()))
                .thenThrow(new AppException(ErrorCode.USERNAME_NOT_FOUND, ""));

        mockMvc.perform(post("/api/v1/users/sign-in")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new SignInRequestDTO(username, password))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("로그인 실패 - 비밀번호 틀림")
    @WithMockUser
    void loginFailPassword() throws Exception {
        String username = "woopaca";
        String password = "woopaca";

        when(userService.signIn(any(), any()))
                .thenThrow(new AppException(ErrorCode.INVALID_PASSWORD, ""));

        mockMvc.perform(post("/api/v1/users/sign-in")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new SignUpRequestDTO(username, password))))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}