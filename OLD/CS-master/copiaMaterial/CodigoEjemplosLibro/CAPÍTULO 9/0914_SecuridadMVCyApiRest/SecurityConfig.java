@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
   @Autowired private UserDetailsService userDetailsService;
   @Autowired private AuthEntryPointJwt authEntryPointJwt;
   @Bean
   public AuthTokenFilter authenticationJwtTokenFilter() {
     return new AuthTokenFilter();
   }
   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
     DaoAuthenticationProvider authProvider = 
                        new DaoAuthenticationProvider();
     authProvider.setUserDetailsService(userDetailsService);
     authProvider.setPasswordEncoder(passwordEncoder());
     return authProvider;
   }
   @Bean
   public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration)throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
   }
   @Bean
   public PasswordEncoder passwordEncoder() { 
      return new BCryptPasswordEncoder();
   }
   @Bean
   @Order(1)
   public SecurityFilterChain ApifilterChain
                                         (HttpSecurity http)throws Exception {
    http.securityMatcher("/api/**");
    http
     .csrf(csrf -> csrf.disable())
     .exceptionHandling(exception -> 
              exception.authenticationEntryPoint(authEntryPointJwt))
     .sessionManagement(session -> session
     .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
     .authorizeHttpRequests(auth -> auth
         // PERMISOS API
     .requestMatchers("/api/**").permitAll() //añadir aquí permisos api
     );
    http.authenticationProvider(authenticationProvider());
    http.addFilterBefore(authenticationJwtTokenFilter(), 
                     UsernamePasswordAuthenticationFilter.class);
    http.cors(Customizer.withDefaults());
    return http.build();
 }
 @Bean
 @Order(2)
 public SecurityFilterChain MvcfilterChain(HttpSecurity http) throws Exception {
   http.headers(headersConfigurer -> headersConfigurer
    .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
   http
    .authorizeHttpRequests(auth -> auth
    // PERMISOS MVC
    .requestMatchers("/**").permitAll()   )  //añadir aquí perm. mvc
    .formLogin(httpSecurityFormLoginConfigurer -> 
                                     httpSecurityFormLoginConfigurer
       .loginPage("/signin") 
       .loginProcessingUrl("/login")
       .failureUrl("/signin?error")
       .defaultSuccessUrl("/public/home", true).permitAll())
    .logout((logout) -> logout.logoutSuccessUrl("/public/home").permitAll())
    .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
    .rememberMe(Customizer.withDefaults())
    .httpBasic(Customizer.withDefaults())
    .exceptionHandling(exceptions -> 
        exceptions.accessDeniedPage("/accessError"));
   return http.build();
 }
}
