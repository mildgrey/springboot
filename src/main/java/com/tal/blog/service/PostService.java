package com.tal.blog.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tal.blog.entity.Post;

public interface PostService {
	List<Post> getAllPosts();
	
	void savePost(Post post);
	
	public Post getPostById(Long id);
	
	void deletePostById(Long Id);
	
	Page<Post> searchPagination(Integer pageNo,int pageSize,String sortField,String sortDirection,String keyword);
	
}
