package com.tal.blog.serviceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tal.blog.entity.Post;
import com.tal.blog.repository.PostRepository;
import com.tal.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Override
   public Set<String> getAllUniqueAuthor(List<Post> posts){
	   Set<String> allAuthor=new HashSet<>();
	   for(Post post:posts) {
			allAuthor.add(post.getAuthor());
		}
	   return allAuthor;
   }
   
   private Pageable getPageable(Integer pageNo, int pageSize,String sortField,String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable=PageRequest.of(pageNo-1, pageSize,sort);
		return pageable;
	}
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public void savePost(Post post) {
		this.postRepository.save(post);
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id).get();
	}


	@Override
	public void deletePostById(Long Id) {
		postRepository.deleteById(Id);
	}
	
	@Override
	public Page<Post> searchPagination(Integer pageNo, int pageSize,String sortField,String sortDirection,String keyword) {
		Pageable pageable=getPageable(pageNo,pageSize,sortField,sortDirection);
		return postRepository.findByKeyword(keyword,pageable);
	}
	
	@Override
	public Page<Post> searchPagination(Integer pageNo, int pageSize,String sortField,String sortDirection,Map<String,String[]> columnAndFilteredColumn) {
		Pageable pageable=getPageable(pageNo,pageSize,sortField,sortDirection);
		String[] authorList=columnAndFilteredColumn.get("author");
		String[] tagNameList=columnAndFilteredColumn.get("tagName");
		System.out.println("author"+authorList[0]);
		System.out.println("tagName"+tagNameList[0]);
		if(!authorList[0].equals("")) {
		    return postRepository.findAllByAuthor(authorList,pageable);
		}
		else
			return postRepository.findAllByTagName(tagNameList,pageable);
			
	}
	

	
}
