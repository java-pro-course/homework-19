package ru.codemika.db.api;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("delete-post-by-id/{Id}")
    public String deletePostById(@PathVariable Long Id){
        return postService.deletePostById(Id);
    }

    @GetMapping("find-post-by-id/{Id}")
    public PostEntity findPostById(@PathVariable Long Id){
        return postService.findPostById(Id);
    }
}
