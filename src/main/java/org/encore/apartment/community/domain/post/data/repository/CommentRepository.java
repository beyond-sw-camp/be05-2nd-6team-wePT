package org.encore.apartment.community.domain.post.data.repository;

import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


//    @Query("SELECT e FROM Post e WHERE e.postId = :postId")
//    List<Comment> findAllByPostId(@Param("postId") Long postId);

    List<Comment> findAllByPost(Post post);

    // public List<Comment> findAllByPostId(Long postId);

}
