package com.ggorrrr.web.controller.service;

import java.util.List;

import com.ggorrrr.web.controller.entity.Member;

public interface MemberService {

	boolean isValidMember(String id, String pwd); // 회원인지확인

	boolean isDuplicatedId(String id); // 아이디중복확인
	
	boolean isFindId(String name,String email); // 아이디 찾기

	List<Member> getMemberList(); // 전체회원관리에서 모든회원리스트

	List<Member> getMemberList(String field, String query); // 전체회원관리 검색

	int insert(Member member); // 회원가입

	int update(Member member); // 비번변경,닉네임변경

	int deletes(int[] ids); // 전체회원관리 일괄삭제

	int delete(int id); // my그먹 회원탈퇴

	Member get(int id); // my그먹, 로그인
	
	Member get(String id);
	
	Member findId(String name);
}
