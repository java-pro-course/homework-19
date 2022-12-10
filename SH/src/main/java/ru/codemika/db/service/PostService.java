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
    public PostEntity findById(Long postId) {
        PostEntity post = postRepository.findById(postId).get();
        return post;
    }

//    public void changeById(Long postId, String content) {
//        postRepository.changeById(postId).setContest(content);
//    }

    public PostEntity createNewPost(CreateNewPost request) {
        PostEntity newPost = new PostEntity();

        newPost.setContest(request.getContent());
        newPost.setDatetime(request.getDatetime());
        newPost.setUserId(request.getUserId());

        return postRepository.save(newPost);
    }
    public String deleteById(Long postId) {
        postRepository.deleteById(postId);
        return String.format("Пост с id: %s успешно удалён", postId);
    }

}
