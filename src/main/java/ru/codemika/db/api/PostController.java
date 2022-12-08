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

    @PostMapping("create-new-post")
    public PostEntity createNewPost(@RequestBody CreateNewPost requestObject){
        return postService.createNewPost(requestObject);
    }

    @GetMapping("find-post-by-id/{postId}")
    public PostEntity findPostById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @GetMapping("find-post-by-userId/{userId}")
    public PostEntity findPostByUserId(@PathVariable Long userId){
        return postService.findByUserId(userId);
    }

    @DeleteMapping("delete-post-by-id/{id}")
    public String deletePostById(@PathVariable Long id){
        return postService.deletePostById(id);
    }

    @PutMapping("update-post/{id}")
    public PostEntity updatePost(@PathVariable Long id, @RequestBody CreateNewPost post){
        return postService.updatePost(id, post);
    }

}
