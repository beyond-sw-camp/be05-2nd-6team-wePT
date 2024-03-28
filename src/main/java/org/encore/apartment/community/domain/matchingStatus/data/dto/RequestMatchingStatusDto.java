package org.encore.apartment.community.domain.matchingStatus.data.dto;

import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestMatchingStatusDto {
	@NotBlank
	private User userId;
}
