package de.linksideal.shelfie.service;

import de.linksideal.shelfie.domain.User;
import de.linksideal.shelfie.dto.UserDto;
import de.linksideal.shelfie.mapper.UserMapper;
import de.linksideal.shelfie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;

    @Transactional
    public UserDto registerNewUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}

