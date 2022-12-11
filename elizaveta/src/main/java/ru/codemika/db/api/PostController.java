package ru.codemika.db.api;

import org.springframework.web.bind.annotation.*;
import ru.codemika.db.dto.CreateNewPost;
import ru.codemika.db.entity.PostEntity;
import ru.codemika.db.entity.UserEntity;
import ru.codemika.db.service.PostService;

@RestController
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("find-by-name/{firstName}/{lastName}")
    public PostEntity findByIdPost(@PathVariable Long id) {
        return postService.findByIdPost(id);
    }

    @PostMapping("create-post")
    public PostEntity createPost(@RequestBody CreateNewPost createNewPost) {
        return postService.createNewPost(createNewPost);
    }
    @GetMapping("delete-by-id/{id}")
    public String deletePostById(@PathVariable Long id) {
        return postService.deleteById(id);
    }

}
