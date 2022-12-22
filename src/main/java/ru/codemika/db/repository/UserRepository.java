package ru.codemika.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.codemika.db.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByEmail(String email);

    @Modifying
    @Query("UPDATE UserEntity user SET user.firstName = ?1, user.lastName = ?2, " +
            "user.age = ?3 WHERE user.id = ?4")
    void updateById(String newFirstName, String newLastName, Long newAge, Long id);
}
