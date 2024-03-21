package org.encore.apartment.community.domain.matchingStatus.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public MatchingStatus(String matchingStatusFollowerId) {

        this.matchingStatusFollowerId = matchingStatusFollowerId;
    }

    public void update(String matchingStatusFollowerId) {

        this.matchingStatusFollowerId = matchingStatusFollowerId;
    }
}

