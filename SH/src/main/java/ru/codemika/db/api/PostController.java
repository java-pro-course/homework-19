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

    @GetMapping("find-post-by-id/{postId}")
    public PostEntity findPostById(@PathVariable Long postId) {
        return postService.findById(postId);
    }

//    @GetMapping("change-post-by-id/{postId}/{newContent}")
//    public void changePostById(@PathVariable Long postId, @PathVariable String content) {
//        postService.changeById(postId, content);
//    }

    @PostMapping("create-new-post")
    public PostEntity createPost(@RequestBody CreateNewPost requestObject) {
        return postService.createNewPost(requestObject);
    }

    @GetMapping("delete-post-by-id/{postId}")
    public String deletePostByEmail(@PathVariable Long postId) {
        return postService.deleteById(postId);
    }

}
