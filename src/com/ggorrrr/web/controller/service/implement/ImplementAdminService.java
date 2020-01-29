package com.ggorrrr.web.controller.service.implement;

import com.ggorrrr.web.controller.dao.AdminDao;
import com.ggorrrr.web.controller.dao.jdbc.JdbcAdminDao;
import com.ggorrrr.web.controller.entity.Admin;
import com.ggorrrr.web.controller.service.AdminService;

public class ImplementAdminService implements AdminService {
	private AdminDao adminDao;

	public ImplementAdminService() {
		adminDao = new JdbcAdminDao();
	}

	@Override
	public boolean isValidAdmin(String id, String pwd) {
		Admin admin = adminDao.get(id);

		if (admin == null)
			return false;
		else if (!admin.getPwd().equals(pwd))
			return false;
		return true;
	}

	@Override
	public int insert(int id) {
		return adminDao.insert(id);
	}

	@Override
	public int delete(int memberId) {
		return adminDao.delete(memberId);
	}

	@Override
	public Admin get(String id) {
		return adminDao.get(id);
	}
}
