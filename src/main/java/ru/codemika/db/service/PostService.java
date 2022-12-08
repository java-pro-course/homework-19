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


    public PostEntity createNewPost(CreateNewPost request) {
        if (postRepository.existsByContent(request.getContent())){
            throw new RuntimeException(
                    String.format("Post with content %s is already exist! Content = %s", request.getContent(), request.getContent())
            );
        }
        PostEntity newPost = new PostEntity();

        newPost.setContent(request.getContent());
        newPost.setDatetime(request.getDatetime());
        newPost.setUser_id(request.getUser_id());

        return postRepository.save(newPost);
    }

    public PostEntity findById(Long id) {
        return postRepository.findById(id).get();
    }

    public PostEntity findByUserId(Long user_id) {
        return postRepository.findByUserId(user_id);
    }

    public String deletePostById(Long id) {
        postRepository.deleteById(id);
        return "deleted!";
    }

    public PostEntity updatePost(Long id, CreateNewPost postDetails) {
        PostEntity updatePost = postRepository.findById(id).get();

        updatePost.setContent(postDetails.getContent());
        updatePost.setDatetime(postDetails.getDatetime());
        updatePost.setUser_id(postDetails.getUser_id());


        return postRepository.save(updatePost);
    }
}
