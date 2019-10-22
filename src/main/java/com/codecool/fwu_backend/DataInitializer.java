package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.FWUAppUser;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final AvailableFlightStorage availableFlightStorage;

    private final UserRepository users;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AvailableFlightStorage availableFlightStorage, UserRepository users) {
        this.availableFlightStorage = availableFlightStorage;
        this.users = users;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(String... args) {

        users.save(FWUAppUser.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles(Arrays.asList( "ROLE_USER"))
                .build()
        );
        users.save(FWUAppUser.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );
        log.debug("printing all users...");
        users.findAll().forEach(v -> log.debug(" FWUAppUser :" + v.toString()));
    }
}
