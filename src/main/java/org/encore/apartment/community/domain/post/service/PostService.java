package org.encore.apartment.community.domain.post.service;

import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public interface PostService {

    void savePost(PostRequestDto postRequestDto);

     List<PostResponseDto> getPostListByCategory(Long postCategoryId);

     List<PostResponseDto> getPostListByUserIdx(Long userIdx);

     List<PostResponseDto> getPostList();

     PostResponseDto getPost(Long postId);

     Long deletePost(Long postId);

     Long updatePost(Long postId, PostUpdateDto postUpdateDto);

     void updatePostRecommend(Long id);

}
