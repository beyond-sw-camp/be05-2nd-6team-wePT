package org.encore.apartment.community.global.handler;

import java.util.NoSuchElementException;

import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "org.encore.apartment.community")
public class ExceptionResponseHandler {
	@ExceptionHandler({IllegalArgumentException.class, NoSuchElementException.class})
	public ResponseEntity<ApiResponse<?>> handleCommonException(Exception e) {
		return ResponseEntity.badRequest().body(ApiResponse.createError(e.getMessage()));
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponse<?>> handleAccessDeniedException() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.createError("접근이 거부되었습니다."));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<?>> handleUnexpectedException() {
		return ResponseEntity.internalServerError().body(ApiResponse.createError("서버에 문제가 발생했습니다."));
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<ApiResponse<?>> handleDuplicatedUserException(RuntimeException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.createError(exception.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<?>> handleValidationExceptions(BindingResult bindingResult) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.createFail(bindingResult));
	}
}
