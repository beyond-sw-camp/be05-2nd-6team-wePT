package org.encore.apartment.community.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.PostCategoryRepositoty;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;

    // category 연결
    // private final PostCategoryRepositoty postCategoryRepositoty;

    // create
    @Transactional
    @Override
    public void savePost(PostRequestDto postRequestDto) {
        postRepository.save(postRequestDto.ToEntity());
    }

    // 카테고리 이름을 입력 받아서 해당하는 카테고리의 포스트만 리스트에 저장 (출력용)
    @Override
    public List<PostResponseDto> getPostListByCategory(Long postCategoryId) {
        Long CategoryId = postRepository.findCategoryId(postCategoryId);
        List<Post> all = postRepository.findAllByPostCategoryId(CategoryId);
        List<PostResponseDto> postDtoList = new ArrayList<>();

        for(Post post : all){
            if (post.getPostDeleteYn() == false) {
                PostResponseDto postDto = PostResponseDto.builder()
                        .postTitle(post.getPostTitle())
                        .postContent(post.getPostContent())
                        .postWriterId(post.getPostWriterId())
                        .postRecommend(post.getPostRecommend())
                        .postDeleteYn(post.getPostDeleteYn())
                        .postCategoryId(post.getPostCategoryId())
                        .postDate(post.getPostDate())
                        .postId(post.getPostId())
                        .build();

                postDtoList.add(postDto);
            }
        }

        return postDtoList;
    }


    // read
    @Transactional
    @Override
    public List<PostResponseDto> getPostList() {
        List<Post> all = postRepository.findAll();
        List<PostResponseDto> postDtoList = new ArrayList<>();

        for(Post post : all){
            if (post.getPostDeleteYn() == false) {
                PostResponseDto postDto = PostResponseDto.builder()
                        .postTitle(post.getPostTitle())
                        .postContent(post.getPostContent())
                        .postWriterId(post.getPostWriterId())
                        .postRecommend(post.getPostRecommend())
                        .postDeleteYn(post.getPostDeleteYn())
                        .postCategoryId(post.getPostCategoryId())
                        .postDate(post.getPostDate())
                        .postId(post.getPostId())
                        .build();

                postDtoList.add(postDto);
            }
        }

        return postDtoList;
    }

    @Override
    public PostResponseDto getPost(Long postId) {

        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        if (post.getPostDeleteYn() == false) {
            return PostResponseDto.builder()
                    .postTitle(post.getPostTitle())
                    .postContent(post.getPostContent())
                    .postWriterId(post.getPostWriterId())
                    .postDate(post.getPostDate())
                    .postRecommend(post.getPostRecommend())
                    .build();
        }else{
            return null;
        }
    }


    // update
    @Transactional
    @Override
    public Long updatePost(Long postId, PostUpdateDto postUpdateDto) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();

        post.update(postUpdateDto.getPostTitle(),
                    postUpdateDto.getPostContent());

        return postId;
    }


    // delete
    @Transactional
    @Override
    public Long deletePost(Long postId) {

        Optional<Post> byId = postRepository.findById(postId);

        if(byId.isPresent()){
            Post post = byId.get();

            post.delete();

            return postId;
        }

        return null;
    }

}
