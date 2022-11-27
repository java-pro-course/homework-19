package ru.codemika.db.api;

import org.springframework.web.bind.annotation.*;
import ru.codemika.db.entity.UserEntity;
import ru.codemika.db.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("find-by-id/{userId}") // kebab-case
    public UserEntity findUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("find-by-email/{userEmail}")
    public UserEntity findUserByEmail(@PathVariable String userEmail) {
        return userService.findByEmail(userEmail);
    }

    // TODO #1: Поиск по имени и фамилии (по firstName and lastName)
    // TODO #2: Создание нового пользователя
    @PostMapping("create-new-user")
    public UserEntity createUser(@RequestBody UserEntity entity) {
        // будет приходить json вот такого вида
        // {"id":2,"firstName":"Ivan","lastName":"Pupkin","age":20,"email":"pupkin@codemika.ru","pass":"12341234"}
        // вызов сервиса, где будет происходить сохранение

        // убрать после выполнения задачи
        return null;
    }

    // TODO #3: При создании нового пользователя необходимо проверять, что его почта уникальна!
    // TODO #4: Удаление пользователя по его id или почте
}
