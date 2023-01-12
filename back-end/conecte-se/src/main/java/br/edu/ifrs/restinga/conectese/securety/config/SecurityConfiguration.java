package br.edu.ifrs.restinga.conectese.securety.config;

import br.edu.ifrs.restinga.conectese.securety.service.AutenticacaoService;
import br.edu.ifrs.restinga.conectese.securety.service.AutenticacaoTokenFilter;
import br.edu.ifrs.restinga.conectese.securety.service.TokenService;
import br.edu.ifrs.restinga.conectese.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final TokenService tokenService;
    
    private final AutenticacaoService autenticacaoService;
    
    private final UsuarioRepository usuarioRepository;
    
    
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
            .antMatchers(HttpMethod.GET, "/oportunidade/buscar").permitAll()
            .antMatchers(HttpMethod.GET, "/oportunidade/buscar/*").permitAll()
            .antMatchers(HttpMethod.POST, "/oportunidade/salvar").permitAll()
            .antMatchers(HttpMethod.POST, "/auth").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
        
    }
    
}
