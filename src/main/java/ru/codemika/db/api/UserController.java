package ru.codemika.db.api;

import org.springframework.web.bind.annotation.*;
import ru.codemika.db.dto.CreateNewUser;
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

    // #1: Поиск по имени и фамилии (по firstName and lastName)
    @GetMapping("find-by-name/{firstName}/{lastName}")
    public UserEntity findByName(@PathVariable String firstName,
                                 @PathVariable String lastName) {
        return userService.findByName(firstName, lastName);
    }


    // #2: Создание нового пользователя
    @PostMapping("create-new-user")
    public UserEntity createUser(@RequestBody CreateNewUser requestObject) {
        // будет приходить json вот такого вида
        // {"id":2,"firstName":"Ivan","lastName":"Pupkin","age":20,"email":"pupkin@codemika.ru","pass":"12341234"}
        // вызов сервиса, где будет происходить сохранение

        return userService.createNewUser(requestObject);
    }

    // #3: При создании нового пользователя необходимо проверять, что его почта уникальна!

    // #4: Удаление пользователя по его id или почте
    @GetMapping("delete-by-id/{id}")
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
