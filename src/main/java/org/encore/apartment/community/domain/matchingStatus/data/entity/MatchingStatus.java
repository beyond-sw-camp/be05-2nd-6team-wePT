package org.encore.apartment.community.domain.matchingStatus.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingStatus {

    @Id
    @Column(name = "matching_status_matching_id")
    private Long matchingStatusMatchingId;

    @Column(name = "matching_status_follower_id")
    private String matchingStatusFollowerId;

    @Builder
    public MatchingStatus(Long matchingStatusMatchingId, String matchingStatusFollowerId) {
        this.matchingStatusMatchingId = matchingStatusMatchingId;
        this.matchingStatusFollowerId = matchingStatusFollowerId;
    }

    public void update(String matchingStatusFollowerId) {

        this.matchingStatusFollowerId = matchingStatusFollowerId;
    }
}

