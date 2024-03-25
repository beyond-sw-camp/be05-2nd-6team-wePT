package org.encore.apartment.community.domain.user.membership.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.user.membership.data.dto.MembershipResponseDto;
import org.encore.apartment.community.domain.user.membership.service.MembershipService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MembershipController {

	private final MembershipService membershipService;

	// TODO: 같은 아파트에 살고 있는 인원들 한꺼번에 추가하는 로직

	/**
	 * 멤버십 등록
	 * @param idx - User의 idx
	 * @return ApiResponse<?>
	 */
	@PostMapping("/insert")
	public ApiResponse<?> insertMembership(@RequestBody Long idx) {
		membershipService.insertMembership(idx);

		return ApiResponse.createSuccessWithNoContent();
	}

	@GetMapping("/list")
	public ApiResponse<List<MembershipResponseDto>> findMembershipList() {
		return ApiResponse.createSuccess(membershipService.findMembershipList());
	}

	@GetMapping("/find")
	public ApiResponse<MembershipResponseDto> findMembership(@RequestParam Long idx) {
		MembershipResponseDto result = membershipService.findMembership(idx);

		return ApiResponse.createSuccess(result);
	}

	@PostMapping("/update")
	public ApiResponse<MembershipResponseDto> updateMembership(@RequestBody Long idx) {
		MembershipResponseDto result = membershipService.updateMembership(idx);

		return ApiResponse.createSuccess(result);
	}

	@DeleteMapping("/delete")
	public ApiResponse<?> deleteMembership(@RequestParam Long idx) {
		membershipService.deleteMembership(idx);

		return ApiResponse.createSuccessWithNoContent();
	}
}
