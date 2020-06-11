package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //ㄹㄹ
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
//@EnableWEbSecurity - Spring security 설정들을 활성화 시켜줌.
//csrf().disable().headers().frameOptions().disable() - h2-console 화면을 사용하기 위해 해당 옵션들을 disable합니다.
//authorizeRequest URL별 권한관리를 설정하는옵션의 시작점. 이게 선언되어야만 antMatchers 옵션 사용 가능
//andMatchers - 권한 관리 대상을 지정하는 옵션. URL, HTTP 메소드별로 관리 가능 , 지정된 url 들은 permitAll() 옵션을 통해 전체 열람 권한 줌
// - /api/ ~ 주소를 가진 API는 USER 권한을 가진 사람만 가능 .
//anyRequest - 설절된 값 이외의 나머지 URL / authenticated - 나머지 URL들은 모두 인증된 사용자들에게만 허용 / 로그인한
//logout().logoutSuccessUrl("/")  로그아웃 기능에 대한 여러 설정의 진입점 / 성공시 / 주소로 이동
//oauth2Login - OAuth2 로그인 기능에 대한 여러 설정의 진입점.
//userinfoEndpoint - OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당.
//userService - 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록.
  // 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시 가능 .
