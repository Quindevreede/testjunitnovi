package nl.novi.testjunitjupiter.controller.controller;


import nl.novi.testjunitjupiter.payload.request.AuthenticationRequest;
import nl.novi.testjunitjupiter.payload.response.AuthenticationResponse;
import nl.novi.testjunitjupiter.service.service.UserAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    UserAuthenticateService userAuthenticateService;

    @Autowired
    public AuthenticationController(UserAuthenticateService userAuthenticateService) {
        this.userAuthenticateService = userAuthenticateService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        AuthenticationResponse authenticationResponse = userAuthenticateService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }

}
