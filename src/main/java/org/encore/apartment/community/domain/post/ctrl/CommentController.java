package org.encore.apartment.community.domain.post.ctrl;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.encore.apartment.community.domain.post.data.dto.*;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.repository.CommentRepository;
import org.encore.apartment.community.domain.post.service.CommentServiceImpl;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentServiceImpl service;
    private final CommentRepository commentRepository;

    @Operation(summary = "댓글 작성")
    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<?> saveComment(@RequestBody CommentRequestDto params) {
        service.saveComment(params);
        return ApiResponse.createSuccessWithNoContent();
    }

    @Operation(summary = "댓글 전체 조회")
    @GetMapping(value = "/view", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<CommentResponseDto>> viewCommentList(){
        List<CommentResponseDto> list = service.getCommentList();
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "게시글 번호로 작성된 댓글 전체 조회 ")
    @GetMapping(value = "/view/{postid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<CommentResponseDto>> viewCommentListByPostId(@PathVariable("postid") Long postId){
        List<CommentResponseDto> list = service.getCommentListByPostId(postId);
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "사용자 정보로 작성 댓글 전체 조회 ")
    @GetMapping(value = "/view/user/{useridx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<CommentResponseDto>> viewCommentListByUserIdx(@PathVariable("useridx") Long userIdx){
        List<CommentResponseDto> list = service.getCommentListByUserIdx(userIdx);
        return ApiResponse.createSuccess(list);
    }


    @Operation(summary = "댓글 수정")
    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<CommentUpdateDto> updateComment(@PathVariable("id") Long commentIdx,
                                    @RequestBody @Valid CommentUpdateDto commentUpdateDto) {

        service.updateComment(commentIdx, commentUpdateDto);
        Optional<Comment> findComment = commentRepository.findById(commentIdx);
        Comment comment = findComment.get();

        CommentUpdateDto returnDto =  new CommentUpdateDto(
                comment.getCommentIdx(),
                comment.getCommentContent(),
                comment.getUpdatedAt()
        );
        return ApiResponse.createSuccess(returnDto);
    }

    @Operation(summary = "댓글 삭제")
    @PutMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<CommentDeleteDto> deletePost(@PathVariable("id") Long commentIdx){

        service.deleteComment(commentIdx);
        Optional<Comment> findComment = commentRepository.findById(commentIdx);
        Comment comment = findComment.get();

        CommentDeleteDto returnDto =  new CommentDeleteDto(
                comment.getCommentIdx(),
                comment.getCommentDeleteYn(),
                comment.getUpdatedAt()
        );

        return ApiResponse.createSuccess(returnDto);
    }


}
