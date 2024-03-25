package org.encore.apartment.community.domain.post.ctrl;

import jakarta.validation.Valid;
import org.encore.apartment.community.domain.post.data.dto.*;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.post.data.repository.CommentRepository;
import org.encore.apartment.community.domain.post.service.CommentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/comment")
public class CommentController {


    private final CommentServiceImpl service;
    private final CommentRepository commentRepository;



    public CommentController(CommentServiceImpl service, CommentRepository commentRepository){
        this.service = service;
        this.commentRepository = commentRepository;
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentResponseDto> savePost(@RequestBody CommentRequestDto params) {

        service.saveComment(params);
        return new ResponseEntity<CommentResponseDto>(HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CommentRequestDto> viewCommentList(@RequestBody CommentRequestDto params){
        service.getPostList(params);
        return null;
    }

    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CommentUpdateDto updateComment(@PathVariable("id") Long commentIdx,
                                    @RequestBody @Valid CommentUpdateDto commentUpdateDto) {

        service.updateComment(commentIdx, commentUpdateDto);
        Optional<Comment> findComment = commentRepository.findById(commentIdx);
        Comment comment = findComment.get();

        return new CommentUpdateDto(
                comment.getCommentIdx(),
                comment.getCommentContent(),
                comment.getCommentWriterId(),
                comment.getUpdatedAt()
        );
    }

    @PutMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CommentDeleteDto deletePost(@PathVariable("id") Long commentIdx,
                                    @RequestBody @Valid CommentDeleteDto commentDeleteDto){

        service.deleteComment(commentIdx, commentDeleteDto);
        Optional<Comment> findComment = commentRepository.findById(commentIdx);
        Comment comment = findComment.get();

        return new CommentDeleteDto(
                comment.getCommentIdx(),
                comment.getCommentWriterId(),
                comment.getCommentDeleteYn()
        );
    }


}
