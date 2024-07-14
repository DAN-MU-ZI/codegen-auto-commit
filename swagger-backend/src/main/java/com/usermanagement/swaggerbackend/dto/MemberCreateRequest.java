package com.usermanagement.swaggerbackend.dto;

import com.usermanagement.swaggerbackend.entity.Member;

public record MemberCreateRequest(String name, String email) {
	public Member toEntity() {
		return Member.builder()
			.name(name)
			.email(email)
			.build();
	}
}
