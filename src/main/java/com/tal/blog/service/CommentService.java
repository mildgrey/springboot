package com.tal.blog.service;

import java.util.List;

import com.tal.blog.entity.Comment;

public interface CommentService {
	List<Comment> getAllComments();
	void saveComment(Comment comment);
	void deleteCommentById(Long Id);
	Comment getCommentById(Long Id);
}
