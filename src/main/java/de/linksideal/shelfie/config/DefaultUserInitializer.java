package de.linksideal.shelfie.config;

import de.linksideal.shelfie.domain.User;
import de.linksideal.shelfie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserInitializer implements CommandLineRunner {

    public static final String ADMIN = "admin";
    public static final String SECRET_ADMIN_PW = "SECRET_ADMIN_PW";
    @Autowired private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername(ADMIN) == null) {
            User user = new User();
            user.setUsername(ADMIN);
            user.setPassword(passwordEncoder.encode(System.getenv(SECRET_ADMIN_PW)));
            userRepository.save(user);
        }
    }
}
