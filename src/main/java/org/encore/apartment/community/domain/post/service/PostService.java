package org.encore.apartment.community.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.PostDeleteDto;
import org.encore.apartment.community.domain.post.data.dto.PostRequestDto;
import org.encore.apartment.community.domain.post.data.dto.PostResponseDto;
import org.encore.apartment.community.domain.post.data.dto.PostUpdateDto;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public interface PostService {

    public void savePost(PostRequestDto postRequestDto);

    public List<PostResponseDto> getPostList(PostRequestDto postRequestDto);

    public PostResponseDto getPost(Long postId);

    public Long deletePost(Long postId, PostDeleteDto postDeleteDto);

    public Long updatePost(Long postId, PostUpdateDto postUpdateDto);

}
