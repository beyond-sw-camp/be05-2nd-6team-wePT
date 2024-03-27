package org.encore.apartment.community.email.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.encore.apartment.community.email.dto.EmailCheckDto;
import org.encore.apartment.community.email.dto.EmailRequestDto;
import org.encore.apartment.community.email.service.MailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/auth")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    /**
     * 사용자가 입력한 이메일 주소로 인증코드를 전송
     * @author Jihwan
     * @param emailRequestDTO 사용자가 입력한 이메일 주소
     * @return 8자리 인증코드
     */
    @PostMapping("/send")
    public String mailSend(@RequestBody @Valid EmailRequestDto emailRequestDTO) {
        return mailService.setEmail(emailRequestDTO.getEmail());
    }

    /**
     * 사용자로부터 인증번호를 입력받아, 전송된 인증번호와 일치한지 확인
     * @author Jihwan
     * @param emailCheckDTO 사용자가 입력한 이메일 주소와 8자리 인증코드
     * @return 인증 성공여부에 따른 결과 메시지
     */
    @PostMapping("/check")
    public String authCheck(@RequestBody @Valid EmailCheckDto emailCheckDTO) {
        boolean checked = mailService.checkAuthNumber(emailCheckDTO.getEmail(), emailCheckDTO.getAuthCode());
        if (checked) {
            return "인증에 성공하였습니다.";
        } else {
            throw new NullPointerException("인증코드가 일치하지 않습니다.");
        }
    }

}