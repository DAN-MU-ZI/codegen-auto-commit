package com.usermanagement.swaggerbackend.dto;

import com.usermanagement.swaggerbackend.entity.Member;
import java.util.List;

public record MemberDto(Long id, String name, String email) {

	public static MemberDto from(Member member) {
		return new MemberDto(member.getId(), member.getName(), member.getEmail());
	}

	public static List<MemberDto> from(List<Member> members) {
		return members.stream()
			.map(member ->
				new MemberDto(member.getId(), member.getName(), member.getEmail())
			).toList();
	}
}
