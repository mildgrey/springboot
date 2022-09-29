package com.tal.blog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.blog.entity.Comment;
import com.tal.blog.repository.CommentRepository;
import com.tal.blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> getAllComments() {
		
		return commentRepository.findAll();
	}

	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
		
	}

	@Override
	public void deleteCommentById(Long Id) {
		commentRepository.deleteById(Id);
	}

	@Override
	public Comment getCommentById(Long Id) {
		
		return commentRepository.findById(Id).get();
	}

}
