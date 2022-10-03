package com.tal.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.tal.blog.entity.Post;

public interface PostService {
	
	Set<String> getAllUniqueAuthor(List<Post> posts);
	
	List<Post> getAllPosts();
	
	void savePost(Post post);
	
	public Post getPostById(Long id);
	
	void deletePostById(Long Id);
	
	Page<Post> searchPagination(Integer pageNo,int pageSize,String sortField,String sortDirection,String keyword);
	
	Page<Post> searchPagination(Integer pageNo,int pageSize,String sortField,String sortDirection,Map<String,String[]> columnAndFilteredColumn);
	
}
