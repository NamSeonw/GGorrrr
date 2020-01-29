package com.ggorrrr.web.controller.service;

import java.util.List;

import com.ggorrrr.web.controller.entity.BookmarkMenu;

public interface BookmarkService {

	int insert(BookmarkMenu bookmarkMenu);

	int delete(int member_id,int food_id);

	List<BookmarkMenu> getList(int member_id);
}
