//package com.example.movie.controller;
//
//import com.example.movie.model.Post;
//import com.example.movie.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/posts")
//public class PostController {
//
//    private final PostService postService;
//
//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }
//
//    @GetMapping
//    public List<Post> getAllPosts() throws Exception {
//        return postService.getAllPosts();
//    }
//
//}
