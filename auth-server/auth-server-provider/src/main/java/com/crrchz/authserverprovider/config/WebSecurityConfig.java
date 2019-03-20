package com.crrchz.authserverprovider.config;

import com.crrchz.authserverprovider.service.UsernameUserDetailService;
import com.crrchz.authserverprovider.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lhj
 * @Description: 这个是auth-server的关键配置：网络安全测试
 * @Date: 2019/1/14 9:55
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自定义用户详细信息插叙[可以直接查询数据库]
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .csrf().disable()
                .httpBasic();
//                //.addFilterAt(getMyLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                // 配置登陆页/login并允许访问
//                .formLogin().loginPage("/login").permitAll()
//                // 登出页
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/backReferer")
//                // 其余所有请求全部需要鉴权认证
//                .and().authorizeRequests().anyRequest().authenticated()
//                // 由于使用的是JWT，我们这里不需要csrf
//                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/favicon.ico");
    }

    /**
     * 用户验证
     * @param auth
     */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        web.ignoring().antMatchers("/favor.ioc");
//        //auth.authenticationProvider(daoAuthenticationProvider());
//    }

//    @Bean
//    public BCryptPasswordEncoder myEncoder(){
//        return new BCryptPasswordEncoder(6);
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider provider1 = new DaoAuthenticationProvider();
//        // 设置userDetailsService
//        provider1.setUserDetailsService(usernameUserDetailService);
//        // 禁止隐藏用户未找到异常
//        provider1.setHideUserNotFoundExceptions(false);
//        // 使用BCrypt进行密码的hash
//        provider1.setPasswordEncoder(myEncoder());
//        return provider1;
//    }
}
