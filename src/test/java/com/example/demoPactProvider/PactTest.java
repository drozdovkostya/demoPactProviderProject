package com.example.demoPactProvider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import com.example.demoPactProvider.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Provider("test_provider")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//pact_broker is the service name in docker-compose
@PactBroker(host = "localhost", port = "80")
public class PactTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void before(PactVerificationContext context) {

        System.setProperty("pact.verifier.publishResults", "true");

        context.setTarget(new HttpTestTarget("localhost", port));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @MockBean
    private UserService userService;

    @State("default")
    public void toDefaultState(Map<String, Object> params) {
//        when(userService.randomUser(any())).thenReturn(User.builder()
//                .id("1")
//                .legacyId(UUID.randomUUID().toString())
//                .name("Beth")
//                .lastLogin(new Date())
//                .build());

    }
}
