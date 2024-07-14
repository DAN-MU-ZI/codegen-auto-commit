package com.usermanagement.swaggerbackend.service;

import com.usermanagement.swaggerbackend.dto.MemberCreateRequest;
import com.usermanagement.swaggerbackend.dto.MemberDto;
import com.usermanagement.swaggerbackend.entity.Member;
import com.usermanagement.swaggerbackend.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public void createMember(final MemberCreateRequest request) {
		Member member = request.toEntity();
		memberRepository.save(member);
	}

	public List<MemberDto> findAllMembers() {
		List<Member> members = memberRepository.findAll();
		return MemberDto.from(members);
	}

	public MemberDto findMemberById(final Long id) {
		return MemberDto.from(memberRepository.findById(id).orElseThrow(EntityNotFoundException::new));
	}
}
