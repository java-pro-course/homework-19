package ru.codemika.db.service;

import org.springframework.stereotype.Service;
import ru.codemika.db.dto.CreateNewUser;
import ru.codemika.db.dto.EditUser;
import ru.codemika.db.entity.UserEntity;
import ru.codemika.db.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Функция сервиса для поиска пользователя по id
     *
     * @param userId id-пользователя
     * @return объект-пользователя
     */
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

    public UserEntity findByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Функция для создания нового пользователя
     *
     * @param request объект нового пользователя
     * @return объект сохраненного пользователя
     */
    public UserEntity createNewUser(CreateNewUser request) {
        // Проверка на уникальность email пользователя
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(
                    String.format("User with email %s is already exist! Email = %s", request.getEmail(), request.getEmail())
            );
        }

        // В случае уникального email - сохраняем объект
        UserEntity newUser = new UserEntity();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setAge(request.getAge());
        newUser.setEmail(request.getEmail());
        newUser.setPass(request.getPass());

        return userRepository.save(newUser);
    }

    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "OK";
    }

    @Transactional // аннотация нужна для того, чтобы спринг-бут понимал, что этот метод полезет в БД и будет транзакция в БД
    public String updateById(Long id, EditUser rq) {
        userRepository.updateById(rq.getFirstName(), rq.getLastName(), rq.getAge(), id);
        return "OK";
    }
}
