package com.quick.response.application.config;

import com.quick.response.application.client.repositories.VoertuigRepository;
import com.quick.response.application.client.repositories.VoertuigTypeRepository;
import com.quick.response.application.client.services.Impl.VoertuigServiceImpl;
import com.quick.response.application.client.services.VoertuigService;
import com.quick.response.application.global.repositories.*;
import com.quick.response.application.global.services.*;
import com.quick.response.application.global.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class BeanConfig {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConfigUploadDocumentRepository configUploadDocumentRepository;
    @Autowired
    private UploadDocumentRepository uploadDocumentRepository;
    @Autowired
    private VoertuigDocumentRepository voertuigDocumentRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private VoertuigRepository voertuigRepository;

    @Autowired
    private VoertuigTypeRepository voertuigTypeRepository;

    @Autowired
    private AanrijdingsformulierRepository aanrijdingsformulierRepository;

    @Autowired
    private RoleService roleService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private FileService fileService;
    @Autowired
    private VoertuigService voertuigService;
    @Autowired
    private AanrijdingsformulierService aanrijdingsformulierService;

    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl(userRepository);
    }

    @Bean
    public VoertuigService voertuigService() {
        return new VoertuigServiceImpl(voertuigRepository, voertuigTypeRepository);
    }

    @Bean
    public AanrijdingsformulierService aanrijdingsformulierService() {
        return new AanrijdingsformulierImpl(aanrijdingsformulierRepository, aanrijdingsformulierService);
    }

    @Bean
    public FileService fileService() {
        return new FileServiceImpl();
    }

    @Bean
    public DocumentService documentService() {
        return new DocumentServiceImpl(configUploadDocumentRepository,
                fileService(),
                uploadDocumentRepository,
                voertuigDocumentRepository,
                documentRepository);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);// setting it to root route of the application
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl(roleRepository);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository, roleService());
    }


}
