
package cz.upol.cled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * Nastavení zabezpečení aplikace CLED.
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

                .requestMatchers(
                    "/admin.html",
                    "/api/admin/**",
                    "/api/uzivatele"
                ).hasRole("ADMIN")

                .requestMatchers(
                    "/svaz.html"
                ).hasRole("SVAZ")

                .requestMatchers(
                    "/krajsky-svaz.html"
                ).hasRole("KRAJSKY_SVAZ")

                .requestMatchers(
                    "/klub.html"
                ).hasRole("KLUB")

                .requestMatchers(
                    "/trener.html"
                ).hasRole("TRENER")

                .requestMatchers(
                    "/cvicenec.html"
                ).hasRole("SPORTOVEC")

                .requestMatchers(
                    "/rodic.html"
                ).hasRole("RODIC")

                .anyRequest().authenticated()
            )

            .userDetailsService(userDetailsService)

            .formLogin(form -> form
                .loginPage("/")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("heslo")
                .successHandler(presmerovaniPodleRole())
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    /**
     * Po přihlášení přesměruje uživatele podle jeho role.
     */
    @Bean
    public AuthenticationSuccessHandler presmerovaniPodleRole() {
        return new AuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Authentication authentication)
                    throws IOException, ServletException {

                String cilovaStranka = "/";

                for (GrantedAuthority authority :
                        authentication.getAuthorities()) {

                    String role = authority.getAuthority();

                    switch (role) {
                        case "ROLE_ADMIN":
                            cilovaStranka = "/admin.html";
                            break;

                        case "ROLE_SVAZ":
                            cilovaStranka = "/svaz.html";
                            break;

                        case "ROLE_KRAJSKY_SVAZ":
                            cilovaStranka = "/krajsky-svaz.html";
                            break;

                        case "ROLE_KLUB":
                            cilovaStranka = "/klub.html";
                            break;

                        case "ROLE_TRENER":
                            cilovaStranka = "/trener.html";
                            break;

                        case "ROLE_SPORTOVEC":
                            cilovaStranka = "/cvicenec.html";
                            break;

                        case "ROLE_RODIC":
                            cilovaStranka = "/rodic.html";
                            break;

                        default:
                            break;
                    }

                    if (!cilovaStranka.equals("/")) {
                        break;
                    }
                }

                response.sendRedirect(
                    request.getContextPath() + cilovaStranka
                );
            }
        };
    }

    /**
     * Encoder pro bezpečné ukládání a ověřování hesel.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Vytvoří AuthenticationManager používaný při přihlašování.
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();
    }
}