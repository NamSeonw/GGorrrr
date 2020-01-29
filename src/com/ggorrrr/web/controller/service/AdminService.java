package com.ggorrrr.web.controller.service;

import com.ggorrrr.web.controller.entity.Admin;

public interface AdminService {
	// 관리자 판별
	boolean isValidAdmin(String id, String pwd);

	// 관리자 추가
	int insert(int id);

	// 관리자 삭제
	int delete(int memberId);

	// 관리자 정보 가져오기
	Admin get(String id);

}
