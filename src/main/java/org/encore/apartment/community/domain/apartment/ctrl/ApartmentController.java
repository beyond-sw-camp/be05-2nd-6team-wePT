package org.encore.apartment.community.domain.apartment.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;
import org.encore.apartment.community.domain.apartment.service.ApartmentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public void insertApartmentInfo(@RequestBody RequestApartmentDto params) {
		service.insertApartmentInfo(params);
		log.info("ApartmentController insertApartmentInfo = {}", params);
	}

	@GetMapping("/find/{id}")
	public Optional<ResponseApartmentDto> findApartmentInfo(@PathVariable Long id) {
		Optional<ResponseApartmentDto> dto = service.findApartmentInfo(id);
		log.info("ApartmentController findApartmentInfo = {}", dto);

		return dto;
	}

	@GetMapping("/list")
	public List<ResponseApartmentDto> findApartmentInfoList() {
		List<ResponseApartmentDto> dto = service.findApartmentInfoList();
		log.info("ApartmentController findApartmentInfoList = {}", dto);

		return dto;
	}

	@PutMapping("/update")
	public void updateApartmentInfo(@RequestBody UpdateApartmentDto params) {
		log.info("ApartmentController updateApartmentInfo = {}", params);
		service.updateApartmentInfo(params);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteApartmentInfo(@PathVariable Long id) {
		log.info("ApartmentController deleteApartmentInfo = {}", id);
		service.deleteApartmentInfo(id);
	}
}
