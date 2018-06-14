package by.nesterenok.testyourself.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
            .disable();
        http.logout()
            .logoutSuccessUrl("/guest")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .and();
        http.authorizeRequests()
            .antMatchers("/user/**")
            .hasRole("USER")
            .antMatchers("/moderator/**")
            .hasRole("MODERATOR")
            .antMatchers("/mentor/**")
            .hasRole("MENTOR")
            .antMatchers("/admin/**")
            .hasRole("ADMIN")
            .antMatchers("/guest/**")
            .anonymous()
            .and();
        http.formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/urlResolver")
            .failureForwardUrl("/not_implemented")
            .permitAll()
            .usernameParameter("user_login")
            .passwordParameter("password_login")
            .isCustomLoginPage();
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(this.dataSource())
            .usersByUsernameQuery("select login, pass, enabled from users where login=?")
            .authoritiesByUsernameQuery("select login, role from users where login =?");
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl(
            "jdbc:mysql://localhost/testyourself?useTimezone=true&serverTimezone=UTC&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Passw0rd");
        return driverManagerDataSource;
    }
}
