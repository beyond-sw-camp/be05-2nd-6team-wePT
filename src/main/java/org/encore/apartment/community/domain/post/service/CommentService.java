package org.encore.apartment.community.domain.post.service;

import org.encore.apartment.community.domain.post.data.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface CommentService {

    void saveComment(CommentRequestDto commentRequestDto);

    List<CommentResponseDto> getCommentList();

    List<CommentResponseDto> getCommentListByPostId(Long postId);

    List<CommentResponseDto> getCommentListByUserIdx(Long userIdx);
    Long deleteComment(Long commentIdx);

    Long updateComment(Long commentIdx, CommentUpdateDto commentUpdateDto);
}
