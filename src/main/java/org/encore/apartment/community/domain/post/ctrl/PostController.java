package org.encore.apartment.community.domain.post.ctrl;


import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.entity.PostCategory;
import org.encore.apartment.community.domain.post.data.repository.PostCategoryRepositoty;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.encore.apartment.community.domain.post.service.PostService;
import org.encore.apartment.community.domain.post.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/post")
public class PostController {
    private final PostServiceImpl service;
    private final PostRepository postRepository;
    private final PostCategoryRepositoty postCategoryRepositoty;



    public PostController(PostServiceImpl service, PostRepository postRepository, PostCategoryRepositoty postCategoryRepositoty){
        this.service = service;
        this.postRepository = postRepository;
        this.postCategoryRepositoty = postCategoryRepositoty;
    }


    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostResponseDto> savePost(@RequestBody PostRequestDto params) {

        service.savePost(params);
        return new ResponseEntity<PostResponseDto>(HttpStatus.OK);
    }

    @GetMapping(value = "/view", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostResponseDto>> viewPostList(){
        List<PostResponseDto> list = service.getPostList();
        return new ResponseEntity<List<PostResponseDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/view/category/{categoryid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostResponseDto>> viewPostListByCategoryId(@PathVariable("categoryid") Long postCategoryId){
        List<PostResponseDto> list = service.getPostListByCategory(postCategoryId);
        return new ResponseEntity<List<PostResponseDto>>(list, HttpStatus.OK);
    }



    @GetMapping(value = "/view/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostResponseDto> viewPost(@PathVariable("id") Long postId){
        PostResponseDto post = service.getPost(postId);

       return new ResponseEntity<PostResponseDto>(post, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PostUpdateDto updatePost(@PathVariable("id") Long postId,
                                      @RequestBody @Valid PostUpdateDto postUpdateDto) {

        Optional<Post> findPost = postRepository.findById(service.updatePost(postId, postUpdateDto));
        if (findPost.isPresent()){
            Post post = findPost.get();

            return new PostUpdateDto(
                    post.getPostId(),
                    post.getPostTitle(),
                    post.getPostContent(),
                    post.getUpdatedAt()
            );
        }
        return null;
    }

    @PutMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PostDeleteDto deletePost(@PathVariable("id") Long postId) {

        service.deletePost(postId);
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
