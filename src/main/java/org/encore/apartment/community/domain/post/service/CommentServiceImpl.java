package org.encore.apartment.community.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.*;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.CommentRepository;
import org.encore.apartment.community.domain.post.data.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    @Override
    @Transactional
    public void saveComment(CommentRequestDto commentRequestDto) {
        commentRepository.save(commentRequestDto.ToEntity());
    }

    @Override
    public List<CommentResponseDto> getPostList(CommentRequestDto commentRequestDto) {
        List<Comment> all = commentRepository.findAll();
        List<CommentResponseDto> commentDtoList = new ArrayList<>();

        for(Comment comment : all){
            CommentResponseDto commentDto = CommentResponseDto.builder()
                    .commentIdx(comment.getCommentIdx())
                    .commentId(comment.getCommentId())
                    .commentWriterId(comment.getCommentWriterId())
                    .postId(comment.getPostId())
                    .commentContent(comment.getCommentContent())
                    .commentDate(comment.getCommentDate())
                    .commentDeleteYn(comment.getCommentDeleteYn())
                    .updatedAt(comment.getUpdatedAt())
                    .build();

            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }

    @Override
    public Long deleteComment(Long commentIdx, CommentDeleteDto commentDeleteDto) {
        Optional<Comment> byId = commentRepository.findById(commentIdx);
        Comment comment = byId.get();

        comment.delete(commentDeleteDto.getCommentDeleteYn());

        return commentIdx;
    }

    @Override
    public Long updateComment(Long commentIdx, CommentUpdateDto commentUpdateDto) {
        Optional<Comment> byId = commentRepository.findById(commentIdx);
        Comment comment = byId.get();

        comment.update(commentUpdateDto.getCommentIdx(),
                    commentUpdateDto.getCommentContent(),
                    commentUpdateDto.getCommentWriterId(),
                    commentUpdateDto.getUpdatedAt());

        return commentIdx;
    }
}
