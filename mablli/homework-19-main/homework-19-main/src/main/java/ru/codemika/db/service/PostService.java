package ru.codemika.db.service;

import org.springframework.stereotype.Service;
import ru.codemika.db.dto.CreateNewPost;
import ru.codemika.db.entity.PostEntity;
import ru.codemika.db.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity createNewPost(CreateNewPost createNewPost) {
        PostEntity entity = new PostEntity();
        entity.setContent(createNewPost.getContent());
        entity.setDate(createNewPost.getDate());

        return postRepository.save(entity);
    }

    public String deletePostById(Long Id){
        postRepository.deleteById(Id);
        return "Post was Deleted";
    }

    public PostEntity findPostById(Long Id){
        return postRepository.findById(Id).get();
    }
}
