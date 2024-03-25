package org.encore.apartment.community.domain.post.data.repository;

import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
