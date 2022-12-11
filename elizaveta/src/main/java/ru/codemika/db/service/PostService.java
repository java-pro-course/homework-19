package ru.codemika.db.service;

import org.springframework.stereotype.Service;
import ru.codemika.db.dto.CreateNewPost;
import ru.codemika.db.entity.PostEntity;
import ru.codemika.db.entity.UserEntity;
import ru.codemika.db.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity findByIdPost(Long id) {
        return postRepository.findByIdPost(id);
    }

    public PostEntity createNewPost(CreateNewPost createNewPost) {
        PostEntity entity = new PostEntity();
        entity.setContent(createNewPost.getContent());
        entity.setDate(createNewPost.getDate());

        return postRepository.save(entity);
    }
    public String deleteById(Long id) {
        postRepository.deleteById(id);
        return "OK";
    }

}
