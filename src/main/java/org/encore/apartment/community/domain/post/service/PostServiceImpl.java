package org.encore.apartment.community.domain.post.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;

    private final UserRepository userRepository;

    // category 연결
    // private final PostCategoryRepositoty postCategoryRepositoty;



    // create
    @Transactional
    @Override
    public void savePost(PostRequestDto postRequestDto) {
        Optional<User> optionalUser = userRepository.findByUserIdx(postRequestDto.getUserIdx());
        postRepository.save(postRequestDto.ToEntity(optionalUser.get()));
    }

    // useridx를 통해서 User가 작성한 포스트의 리스트 저장 (출력용)
    public List<PostResponseDto> getPostListByUserIdx(Long userIdx){

        User user = userRepository.findByUserIdx(userIdx).get();
        List<Post> all = postRepository.findAllByUser(user);
        List<PostResponseDto> postDtoList = new ArrayList<>();

        for(Post post : all){
            if (post.getPostDeleteYn() == false) {
                PostResponseDto postDto = PostResponseDto.builder()
                        .postTitle(post.getPostTitle())
                        .postContent(post.getPostContent())
                        .userIdx(post.getUser().getUserIdx())
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
                        .userIdx(post.getUser().getUserIdx())
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
                        .userIdx(post.getUser().getUserIdx())
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

    @Transactional
    @Override
    public void updatePostRecommend(Long postId){
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        post.recommend();
        postRepository.save(post);
    }

    // postId로 post 확인
    @Override
    public PostResponseDto getPost(Long postId) {

        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        if (post.getPostDeleteYn() == false) {
            return PostResponseDto.builder()
                    .postTitle(post.getPostTitle())
                    .postContent(post.getPostContent())
                    .userIdx(post.getUser().getUserIdx())
                    .postRecommend(post.getPostRecommend())
                    .postDeleteYn(post.getPostDeleteYn())
                    .postCategoryId(post.getPostCategoryId())
                    .postDate(post.getPostDate())
                    .postId(post.getPostId())
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
