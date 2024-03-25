package org.encore.apartment.community.domain.post.data.repository;

import org.encore.apartment.community.domain.post.data.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepositoty extends JpaRepository<PostCategory, Long> {
}
