package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestSearchMatchingDto {

	@NotNull
	private Long matchingId;

}