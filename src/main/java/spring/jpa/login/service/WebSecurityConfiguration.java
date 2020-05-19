package spring.jpa.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.jpa.login.service.LoginUsersDetailsService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    LoginUsersDetailsService loginUsersDetailsService;


    /**
     * @param auth this is used for spring security authorization
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUsersDetailsService);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("Authorization Called========>");
        http.authorizeRequests()
                .antMatchers("/sublabh/user").hasAnyRole("USER","ADMIN")
                //.antMatchers("/sublabh/login").hasRole("USER")
                .antMatchers("/sublabh/login").permitAll()
                .antMatchers("/h2-console").permitAll()
                .and().formLogin();
        http.csrf().disable();
        http.headers().frameOptions().disable();

        System.out.println("Authorization exit========>");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}