package br.com.rushando.gdemandas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/signin.css", "/fontawesome/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.jdbcAuthentication().dataSource(dataSource)
	          .usersByUsernameQuery("select email username, senha password, ativo enabled"
	              + " from usuario where email=?")
	          .authoritiesByUsernameQuery("select u.email username, p.regra authority "
	              + "from usuario u, permissao p "
	              + "where u.email=? "
	              + "and p.idusuario = u.idusuario")
	          .passwordEncoder(new BCryptPasswordEncoder());
    }
}
