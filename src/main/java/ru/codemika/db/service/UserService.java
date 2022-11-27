package ru.codemika.db.service;

import org.springframework.stereotype.Service;
import ru.codemika.db.entity.UserEntity;
import ru.codemika.db.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long userId) {
        // findById возвращает не просто UserEntity, а Optional<UserEntity>.
        // чтобы от этого избавиться - необходимо написать .get() в конце
        UserEntity user = userRepository.findById(userId).get();
        return user;
    }

    public UserEntity findByEmail(String userEmail) {
        UserEntity user = userRepository.findByEmail(userEmail);
        return user;
    }
}
