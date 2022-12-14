package com.tal.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tal.blog.entity.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
	List<Tag> findTagByName(String name);
}
