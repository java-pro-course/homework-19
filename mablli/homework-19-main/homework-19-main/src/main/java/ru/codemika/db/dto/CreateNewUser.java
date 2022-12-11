package ru.codemika.db.dto;

/**
 * Класс, который описывает json-запрос на создание нового пользователя
 * Отличие от Entity - отсутствие связки с таблицей и нет ID
 */
public class CreateNewUser {
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String pass;

    public CreateNewUser(String firstName, String lastName, Long age, String email, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
