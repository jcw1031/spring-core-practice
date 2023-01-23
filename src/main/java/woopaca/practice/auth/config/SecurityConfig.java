package woopaca.practice.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable() // UI 쪽 disable
                .csrf().disable() // cross site 기능?
                .cors().and() //cross site에서 도메인이 다를 때 허용
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // 허용
                .antMatchers("/api/v1/users/sign-up", "/api/v1/users/sign-in").permitAll() // 허용
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 이용 시 사용
                .and()
//                .addFilterBefore(new JwtTokenFilter(userService, secretKey), UsernamePasswordAuthenticationToken)
                .build();
    }
}
