package com.example.LoginRegistrationBackendAndEmailVerification.registration;

import com.example.LoginRegistrationBackendAndEmailVerification.app_user.AppUser;
import com.example.LoginRegistrationBackendAndEmailVerification.app_user.AppUserRole;
import com.example.LoginRegistrationBackendAndEmailVerification.app_user.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest registrationRequest) {
        String email = registrationRequest.getEmail();
        boolean isValidEmail = emailValidator.test(email);

        if(!isValidEmail) {
            throw new IllegalStateException(String.format("Email not valid: %s", email));
        }

        return appUserService.signUpAppUser(
                new AppUser(
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        AppUserRole.USER));
    }
}
