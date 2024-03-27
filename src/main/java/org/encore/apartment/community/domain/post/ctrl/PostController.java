package org.encore.apartment.community.domain.post.ctrl;



import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.encore.apartment.community.domain.post.service.PostServiceImpl;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private final PostServiceImpl service;
    private final PostRepository postRepository;

    @Operation(summary = "게시글 작성")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<?> savePost( @RequestBody PostRequestDto params) {

        service.savePost(params);
        return ApiResponse.createSuccessWithNoContent();

    }

    @Operation(summary = "게시글 전체 조회")
    @GetMapping(value = "/view", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<PostResponseDto>> viewPostList(){
        List<PostResponseDto> list = service.getPostList();
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "선택 카테고리의 게시글 전체 조회")
    @GetMapping(value = "/view/category/{categoryid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<PostResponseDto>> viewPostListByCategoryId(@PathVariable("categoryid") Long postCategoryId){
        List<PostResponseDto> list = service.getPostListByCategory(postCategoryId);
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "선택 작성자의 게시글 전체 조회")
    @GetMapping(value = "/view/user/{useridx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<PostResponseDto>> viewPostListByUserIdx(@PathVariable("useridx") Long userIdx){
        List<PostResponseDto> list = service.getPostListByUserIdx(userIdx);
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "게시글 번호로 게시글 조회")
    @GetMapping(value = "/view/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<PostResponseDto> viewPost(@PathVariable("id") Long postId){
        PostResponseDto post = service.getPost(postId);
        return ApiResponse.createSuccess(post);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<?> updatePost(@PathVariable("id") Long postId,
                                      @RequestBody @Valid PostUpdateDto postUpdateDto) {

        Optional<Post> findPost = postRepository.findById(service.updatePost(postId, postUpdateDto));
        if (findPost.isPresent()){
            Post post = findPost.get();

            PostUpdateDto returnDto = new PostUpdateDto(
                    post.getPostId(),
                    post.getPostTitle(),
                    post.getPostContent(),
                    post.getUpdatedAt()
            );
            return ApiResponse.createSuccess(returnDto);
        }
        return ApiResponse.createSuccessWithNoContent();
    }

    @Operation(summary = "게시글 추천수 증가")
    @GetMapping("/update-recommend/{id}")
    public ApiResponse<?> updateRecommend(@PathVariable("id") Long postId) {
        service.updatePostRecommend(postId);
        return ApiResponse.createSuccessWithNoContent();
    }

    @Operation(summary = "게시글 삭제")
    @PutMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<PostDeleteDto> deletePost(@PathVariable("id") Long postId) {

        service.deletePost(postId);
        Optional<Post> findPost = postRepository.findById(postId);
        Post post = findPost.get();

        PostDeleteDto returnDto =  new PostDeleteDto(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getPostDeleteYn(),
                post.getUpdatedAt()
        );
        return ApiResponse.createSuccess(returnDto);
    }

}
