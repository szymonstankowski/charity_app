package pl.coderslab.charity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService(){
        return new SpringDataUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       http.cors().disable();
//       http.csrf().disable(
//       http.headers().disable();

        http.authorizeRequests()
                .antMatchers("/aboutUs","/about", "/register", "/login","/institutions","/contact", "/", "/resources/**", "/images/**","/check").permitAll()
                .antMatchers("/admin","/","/users","/institutions","/users/delete").hasRole("ADMIN")
                .antMatchers("/donation", "/adddonation", "/").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/check")
                .and().logout().logoutSuccessUrl("/")
                .permitAll();
    }
}
