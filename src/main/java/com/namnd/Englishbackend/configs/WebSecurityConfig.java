package com.namnd.Englishbackend.configs;

import com.namnd.Englishbackend.securities.AuthEntryPointJwt;
import com.namnd.Englishbackend.securities.AuthTokenFilter;
import com.namnd.Englishbackend.securities.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:14 PM
 */

@Configuration

/**
 * cho phép Spring tìm và tự động áp dụng lớp vào Bảo mật Web.
 */
@EnableWebSecurity

/**
 * cung cấp bảo mật AOP trên các phương thức.
 * Nó cho phép @PreAuthorize, @PostAuthorize...
 */
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * phương thức từ WebSecurityConfigurerAdapter.
     * Nó cho Spring Security biết cách chúng ta định cấu hình CORS và CSRF,
     * khi nào chúng ta muốn yêu cầu tất cả người dùng phải được xác thực hay không,
     * bộ lọc nào (AuthTokenFilter) và khi nào chúng ta muốn nó hoạt động (lọc trước UsernamePasswordAuthenticationFilter),
     * Bộ xử lý ngoại lệ nào được chọn (AuthEntryPointJwt).
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
