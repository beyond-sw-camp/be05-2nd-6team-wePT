package org.encore.apartment.community.domain.post.data.repository;

import org.encore.apartment.community.domain.post.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*
    @Query("SELECT generalMaintenanceFee FROM MaintenanceFee m WHERE m.user.userIdx=:userIdx")
    Integer findGeneralMaintenanceFeeByUserIdx(@Param("userIdx") Long userIdx);
     */


    @Query("select c.postCategoryId from PostCategory c left outer join Post p on c.postCategoryId = p.postCategoryId where c.postCategoryId=:postCategoryId")
    Long findCategoryId(@Param("postCategoryId") Long postCategoryId);

    public List<Post> findAllByPostCategoryId(Long postCategoryId);

}
