package org.encore.apartment.community.domain.apartment.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateRequestApartmentDto;
import org.encore.apartment.community.domain.apartment.service.ApartmentService;
import org.encore.apartment.community.global.annotation.AdminAuthorize;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/apartment")
public class ApartmentController {

	@Resource(name = "apartment")
	private ApartmentService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertApartmentInfo(@RequestBody RequestApartmentDto params) {
		service.insertApartmentInfo(params);
		log.info("ApartmentController insertApartmentInfo = {}", params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseApartmentDto>> findApartmentInfo(@PathVariable Long id) {
		Optional<ResponseApartmentDto> dto = service.findApartmentInfo(id);
		log.info("ApartmentController findApartmentInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseApartmentDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	@AdminAuthorize
	public ResponseEntity<List<ResponseApartmentDto>> findApartmentInfoList() {
		List<ResponseApartmentDto> dto = service.findApartmentInfoList();
		log.info("ApartmentController findApartmentInfoList = {}", dto);

		return new ResponseEntity<List<ResponseApartmentDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	@AdminAuthorize
	public ApiResponse<ResponseApartmentDto> updateApartmentInfo(@PathVariable("id") Long id, @RequestBody UpdateRequestApartmentDto params) {
		log.info("ApartmentController updateApartmentInfo = {}", params);

		return ApiResponse.createSuccess(service.updateApartmentInfoById(id, params));
	}

	@DeleteMapping("/delete/{id}")
	@AdminAuthorize
	public ResponseEntity<Void> deleteApartmentInfo(@PathVariable Long id) {
		log.info("ApartmentController deleteApartmentInfo = {}", id);
		service.deleteApartmentInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
