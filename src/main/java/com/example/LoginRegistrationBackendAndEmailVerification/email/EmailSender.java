package com.example.LoginRegistrationBackendAndEmailVerification.email;

public interface EmailSender {
    void send(String to, String email);
}