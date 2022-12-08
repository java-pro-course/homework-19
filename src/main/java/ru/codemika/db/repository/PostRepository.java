package ru.codemika.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codemika.db.entity.PostEntity;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    boolean existsByContent(String content);

    PostEntity findByUserId(Long user_id);

}
