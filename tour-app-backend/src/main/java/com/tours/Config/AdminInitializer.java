package com.tours.Config;

import com.tours.Entities.Users;
import com.tours.Repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.name}")
    private String adminName;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Value("${app.admin.contact}")
    private String adminContact;

    public AdminInitializer(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createDefaultAdmin() {

        if (userRepo.existsByEmail(adminEmail)) {
            return;
        }

        Users admin = new Users();
        admin.setName(adminName);
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setContactNumber(adminContact);
        admin.setRole("ROLE_ADMIN");
        admin.setEnabled(true);

        userRepo.save(admin);
    }
}