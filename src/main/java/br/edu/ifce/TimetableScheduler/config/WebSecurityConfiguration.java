package br.edu.ifce.TimetableScheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/pagina-de-logout")
            .permitAll()
            .and()
        .rememberMe();

    return http.build();
	}
	
	@Bean
	 public WebSecurityCustomizer ignoringCustomizer() {
	        return (web) -> web.ignoring().requestMatchers("/resources/**", "/webjars/**", "/css/**");
	 }
	
	@Bean
	CustomUserDetails customUserDetailsService() {
		return new CustomUserDetails();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
