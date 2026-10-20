package cz.upol.cled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

/**
 * Nastavení zabezpečení aplikace CLED.
 *
 * Veřejně dostupná je přihlašovací stránka.
 * Ostatní API endpointy budou vyžadovat přihlášení.
 */
@Bean
public SecurityFilterChain securityFilterChain(
        HttpSecurity http,
        UserDetailsService userDetailsService) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/",
                "/index.html",
                "/images/**"
            ).permitAll()
            .anyRequest().authenticated()
        )
        .userDetailsService(userDetailsService)
        .formLogin(form -> form
            .loginPage("/")
            .loginProcessingUrl("/login")
            .usernameParameter("email")
            .passwordParameter("heslo")
            .defaultSuccessUrl("/", true)
            .permitAll()
        );

    return http.build();
}

/**
 * Encoder pro bezpečné ukládání a ověřování hesel.
 *
 * @return BCrypt password encoder
 */
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

/**
 * Vytvoří AuthenticationManager používaný při přihlašování.
 *
 * @param config konfigurace autentizace
 * @return authentication manager
 * @throws Exception pokud se nepodaří vytvořit manager
 */
@Bean
public AuthenticationManager authenticationManager(
        AuthenticationConfiguration config) throws Exception {

    return config.getAuthenticationManager();
}

}