package com.usermanagement.swaggerbackend.controller;

import com.usermanagement.swaggerbackend.dto.MemberCreateRequest;
import com.usermanagement.swaggerbackend.dto.MemberDto;
import com.usermanagement.swaggerbackend.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	// 멤버 생성
	@PostMapping
	public void createMember(@RequestBody MemberCreateRequest request) {
		memberService.createMember(request);
	}

	// 멤버 전체 조회
	@GetMapping
	public List<MemberDto> findAllMembers() {
		return memberService.findAllMembers();
	}

	// Id 기반 멤버 조회
	@GetMapping("/{id}")
	public MemberDto findMemberById(@PathVariable("id") final Long id) {
		return memberService.findMemberById(id);
	}
}
