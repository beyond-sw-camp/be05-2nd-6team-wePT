package org.encore.apartment.community.domain.post.ctrl;


import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.encore.apartment.community.domain.post.service.PostService;
import org.encore.apartment.community.domain.post.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/post")
public class PostController {
    private final PostServiceImpl service;
    private final PostRepository postRepository;



    public PostController(PostServiceImpl service, PostRepository postRepository){
        this.service = service;
        this.postRepository = postRepository;
    }


    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostResponseDto> savePost(@RequestBody PostRequestDto params) {

        service.savePost(params);
        return new ResponseEntity<PostResponseDto>(HttpStatus.OK);
    }

    @GetMapping(value = "/view", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PostRequestDto> viewPostList(@RequestBody PostRequestDto params){
        service.getPostList(params);
        return null;
    }

    @GetMapping(value = "/view/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PostResponseDto getPost(@PathVariable("id") Long postId){
        PostResponseDto post = service.getPost(postId);

       return null;
    }

    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PostUpdateDto updatePost(@PathVariable("id") Long postId,
                                      @RequestBody @Valid PostUpdateDto postUpdateDto) {

        service.updatePost(postId, postUpdateDto);
        Optional<Post> findPost = postRepository.findById(postId);
        Post post = findPost.get();

        return new PostUpdateDto(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getUpdatedAt()
        );
    }

    @PutMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PostDeleteDto deletePost(@PathVariable("id") Long postId,
                                    @RequestBody @Valid PostDeleteDto postDeleteDto) {

        service.deletePost(postId, postDeleteDto);
        Optional<Post> findPost = postRepository.findById(postId);
        Post post = findPost.get();

        return new PostDeleteDto(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getPostDeleteYn()
        );
    }

}
