package org.lol.Lol.service;

import org.lol.Lol.dto.CreateNewUser;
import org.lol.Lol.entity.UserEntity;
import org.lol.Lol.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findUserById(Long userId) {
        // findById возвращает не просто UserEntity, а Optional<UserEntity>.
        // чтобы от этого избавиться - необходимо написать .get() в конце
        UserEntity user = userRepository.findById(userId).get();
        return user;
    }
    public UserEntity findByEmail(String userEmail) {
        UserEntity user = userRepository.findByEmail(userEmail);
        return user;
    }
    public UserEntity findByName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    public UserEntity createNewUser(CreateNewUser createNewUserRequest){
        if (userRepository.existsByEmail(createNewUserRequest.getEmail())){
            throw new RuntimeException(String.format("Пользователь с электронной почтой %s уже существует!", createNewUserRequest.getEmail()));
        }

        UserEntity newUser = new UserEntity();

        newUser.setFirstName(createNewUserRequest.getFirstName());
        newUser.setLastName(createNewUserRequest.getLastName());
        newUser.setAge(createNewUserRequest.getAge());
        newUser.setEmail(createNewUserRequest.getEmail());
        newUser.setPass(createNewUserRequest.getPass());

        return userRepository.save(newUser);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public void deleteUserByEmail(String email){
        deleteUserById(findByEmail(email).getId());
    }
}