package rubiya.oauth2.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

@Configuration
public class TestSecurityConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        // Dummy client registration for tests
        ClientRegistration registration = ClientRegistration.withRegistrationId("test")
                .clientId("dummy-client-id")
                .clientSecret("dummy-client-secret")
                .authorizationUri("https://example.com/oauth2/authorize")
                .tokenUri("https://example.com/oauth2/token")
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("read")
                .authorizationGrantType(org.springframework.security.oauth2.core.AuthorizationGrantType.AUTHORIZATION_CODE)
                .build();

        return new InMemoryClientRegistrationRepository(registration);
    }
}
