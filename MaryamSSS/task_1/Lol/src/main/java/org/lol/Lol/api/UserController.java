package org.lol.Lol.api;
import org.lol.Lol.dto.CreateNewUser;
import org.lol.Lol.entity.UserEntity;
import org.lol.Lol.service.UserService;
import org.springframework.web.bind.annotation.*;


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

    // Done: Поиск по имени и фамилии (по firstName and lastName)
    @GetMapping("find-by-name/{firstName}/{lastName}")
    public UserEntity findByName(@PathVariable String firstName,
                                 @PathVariable String lastName) {
        return userService.findByName(firstName, lastName);
    }
    // Done: #2: Создание нового пользователя
    @PostMapping("create-new-user")
    public UserEntity createUser(@RequestBody CreateNewUser requestObject) {
        // будет приходить json вот такого вида
        // {"id":2,"firstName":"Ivan","lastName":"Pupkin","age":20,"email":"pupkin@codemika.ru","pass":"12341234"}
        // вызов сервиса, где будет происходить сохранение

        // убрать после выполнения задачи
        return userService.createNewUser(requestObject);
    }

    // Done: #3: При создании нового пользователя необходимо проверять, что его почта уникальна!
    // TODO #4: Удаление пользователя по его id или почте
    @GetMapping("delete-user-by-id/{id}")
    public void deleteUserById(@PathVariable Long id){
    }
}
