package org.lol.Lol.service;

import org.lol.Lol.dto.CreateNewPost;
import org.lol.Lol.dto.EditPost;
import org.lol.Lol.entity.PostEntity;
import org.lol.Lol.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostEntity createNewPost(CreateNewPost createNewPostRequest){
        PostEntity newPost = new PostEntity();
        newPost.setContent(createNewPostRequest.getContent());
        newPost.setDatetime(createNewPostRequest.getDatetime());
        return postRepository.save(newPost);
    }
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
    public PostEntity editPost(EditPost editPostRequest){
        PostEntity editPost = new PostEntity();
        editPost.setContent(editPostRequest.getContent());
        editPost.setDatetime(editPostRequest.getDatetime());
        return postRepository.save(editPost);
    }
    public PostEntity findPostById(Long postId){
        return postRepository.findById(postId).get();
    }
}
