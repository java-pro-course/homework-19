package org.lol.Lol.api;

import org.lol.Lol.dto.CreateNewPost;
import org.lol.Lol.dto.EditPost;
import org.lol.Lol.entity.PostEntity;
import org.lol.Lol.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("create-new-post")
    public PostEntity createPost(@RequestBody CreateNewPost requestObject){
        return postService.createNewPost(requestObject);
    }
    @GetMapping("delete-post/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
    @GetMapping("edit-post")
    public PostEntity editPost(@RequestBody EditPost requestObject){
        return postService.editPost(requestObject);
    }
    @GetMapping("find-post-by-id/{id}")
    public PostEntity findPost(@PathVariable Long id){
        return postService.findPostById(id);
    }
}
