package org.lol.Lol.repository;

import org.lol.Lol.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByEmail(String email);
}