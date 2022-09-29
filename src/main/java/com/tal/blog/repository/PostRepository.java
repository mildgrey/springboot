package com.tal.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.tal.blog.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

//	@Query(value="SELECT * FROM posts "
//			+ " JOIN post_tag ON posts.post_id= post_tag.post_id "
//			+ " JOIN tags ON tags.tag_id=post_tag.tag_id "
//			+ " WHERE posts.title like  ?1 ",nativeQuery = true)
//	
	@Query("SELECT DISTINCT p FROM Post p JOIN p.tags t WHERE p.title LIKE %?1% OR p.content LIKE %?1% OR p.excerpt LIKE %?1%")
	public Page<Post> findByKeyword(String keyword,Pageable pageable);
	
	
}
