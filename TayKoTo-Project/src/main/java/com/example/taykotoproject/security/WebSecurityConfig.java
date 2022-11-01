package com.example.taykotoproject.security;
import com.example.taykotoproject.common.Constans;
import com.example.taykotoproject.model.CustomOAuth2User;
import com.example.taykotoproject.security.service.UserDetailsServiceImpl;
import com.example.taykotoproject.service.CustomOAuth2UserService;
import com.example.taykotoproject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private CustomOAuth2UserService oauthUserService;

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/management")
                .access("hasRole( '" + Constans.ROLE_ADMIN + "')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");



        http.authorizeRequests().antMatchers(
                "*/assets/**",
                "/assets/css/**",
                "/assets/fonts/**",
                "/assets/js/**",
                "/assets/images/**",
                "*/upload/**",
                "/upload/*",
                "/",
                "/home",
                "/fonts/fontawesome-webfont.eot?v=4.7.0",
                "/fonts/fontawesome-webfont.eot?#iefix&v=4.7.0",
                "https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i",
                "/index",
                "/login-register",
                "/register",
                "/search",
                "/oauth/**",
                "/deal",
                "/car/*",
                "/car/**",
                "/cars"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/")
                .defaultSuccessUrl("/home")
                .failureUrl("/login=fail")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll().and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .formLogin().permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login-register")
                .userInfoEndpoint()
                .userService(oauthUserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        System.out.println("AuthenticationSuccessHandler invoked");
                        System.out.println("Authentication name: " + authentication.getName());
                        //CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

                        DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
                        String email = oauthUser.getAttribute("email");

                        usersService.processOAuthPostLogin(email);

                        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                        UsernamePasswordAuthenticationToken authentications = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentications.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        response.sendRedirect("/home");
                    }
                })
//                .defaultSuccessUrl("/home")
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");


        }
}