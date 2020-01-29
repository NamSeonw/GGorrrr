package com.ggorrrr.web.controller.dao;

import com.ggorrrr.web.controller.entity.Admin;

public interface AdminDao {
	// 관리자 등록
	int insert(int memberId);

	// 관리자 삭제
	int delete(int memberId);

	// 관리자 정보 가져오기.
	Admin get(String id);

}
