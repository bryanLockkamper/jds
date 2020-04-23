package be.ucm.jds.configuration;

import be.ucm.jds.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/creerGenre").hasRole("ADMIN")
                .antMatchers("/supprimerGenre").hasRole("ADMIN")
                .antMatchers("/modifierGenre").hasRole("ADMIN")
                .antMatchers("/genre/**").authenticated()
                .antMatchers("/genres").authenticated()
                .antMatchers("/creerJeu").hasRole("ADMIN")
                .antMatchers("/supprimerJeu").hasRole("ADMIN")
                .antMatchers("/modifierJeu").hasRole("ADMIN")
                .antMatchers("/jeux").authenticated()
                .antMatchers("/jeu/**").authenticated()
                .antMatchers("/creerRencontre").hasRole("ADMIN")
                .antMatchers("/supprimerRencontre").hasRole("ADMIN")
                .antMatchers("/modifierRencontre").hasRole("ADMIN")
                .antMatchers("/rencontre/**").authenticated()
                .antMatchers("/rencontres").authenticated()
                .antMatchers("/actualRencontres").authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .httpBasic()
                .disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(utilisateurService).passwordEncoder(passwordEncoder);
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource()
//    {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
