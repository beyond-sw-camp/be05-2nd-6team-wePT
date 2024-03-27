package org.encore.apartment.community.domain.post.service;

import org.encore.apartment.community.domain.post.data.dto.*;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface CommentService {

    public void saveComment(CommentRequestDto commentRequestDto);

    public List<CommentResponseDto> getCommentList();

    public List<CommentResponseDto> getCommentListByPostId(Long postId);

    public Long deleteComment(Long commentIdx);

    public Long updateComment(Long commentIdx, CommentUpdateDto commentUpdateDto);
}
