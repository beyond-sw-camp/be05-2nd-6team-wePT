package org.encore.apartment.community.domain.post.service;

import org.encore.apartment.community.domain.post.data.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface CommentService {

    public void saveComment(CommentRequestDto commentRequestDto);

    public List<CommentResponseDto> getPostList(CommentRequestDto commentRequestDto);

    public Long deleteComment(Long commentIdx, CommentDeleteDto commentDeleteDto);

    public Long updateComment(Long commentIdx, CommentUpdateDto commentUpdateDto);
}
