package com.tal.blog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.blog.entity.Tag;
import com.tal.blog.repository.TagRepository;
import com.tal.blog.service.TagService;

@Service
public class TagServiceImpl implements TagService{
	@Autowired
	private TagRepository tagRepository;

	@Override
	public List<Tag> getTagsByName(String name) {
		return tagRepository.findTagByName(name);
	}

	@Override
	public void saveTag(Tag tag) {
		tagRepository.save(tag);
	}	
}
