package ru.codemika.db.service;

import org.springframework.stereotype.Service;
import ru.codemika.db.dto.CreateNewUser;
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
        return userRepository.findById(userId).get();
    }

    public UserEntity findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public UserEntity findByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public UserEntity createNewUser(CreateNewUser request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(
                    String.format("User with email %s is already exist! Email = %s", request.getEmail(), request.getEmail())
            );
        }
        UserEntity newUser = new UserEntity();

        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAge(request.getAge());
        newUser.setEmail(request.getEmail());
        newUser.setPass(request.getPass());

        return userRepository.save(newUser);
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        userRepository.deleteById(user.getId());
        return "deleted!";
    }
}
