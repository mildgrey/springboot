package com.tal.blog.service;

import java.util.List;

import com.tal.blog.entity.Tag;

public interface TagService {
	
	List<Tag> getTagsByName(String name);
	
	void saveTag(Tag tag);
}
