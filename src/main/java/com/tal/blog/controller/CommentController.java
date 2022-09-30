package com.tal.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tal.blog.entity.Comment;
import com.tal.blog.entity.Post;
import com.tal.blog.service.CommentService;
import com.tal.blog.service.PostService;
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private PostService postService;
	
	@PostMapping("/createComment/{id}")
	public String createComment(@PathVariable("id") Long id,@ModelAttribute Comment comment) {
		Post post = new Post();
		post=postService.getPostById(id);
		comment.setPost(post);
		commentService.saveComment(comment);
		return "redirect:/fullContent/"+id;
	}
	@GetMapping("/editComment/{commentId}")
	public String updateComment(@PathVariable("commentId") Long commentId,Model model) {
		Comment comment = new Comment();
		
		comment = commentService.getCommentById(commentId);
		commentService.deleteCommentById(commentId);
		model.addAttribute("comment",comment);
		return "editComments";
	}
	
	@GetMapping("/deleteComment/{commentId}")
	public String deleteComment(@PathVariable("commentId") Long commentId) {
		Comment comment=new Comment();
		comment = commentService.getCommentById(commentId);
		Long postId=comment.getPost().getPostId();
		commentService.deleteCommentById(commentId);
		return "redirect:/fullContent/"+postId;
	}

}
