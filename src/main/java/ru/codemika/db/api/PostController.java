package ru.codemika.db.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.codemika.db.dto.CreateNewPost;
import ru.codemika.db.entity.PostEntity;
import ru.codemika.db.service.PostService;

@RestController
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("create-post")
    public PostEntity createPost(@RequestBody CreateNewPost createNewPost) {
        return postService.createNewPost(createNewPost);
    }
}
