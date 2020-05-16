package com.fisadyukovasecondattempt.SafeSpaceForYou.controller;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.Post;
import com.fisadyukovasecondattempt.SafeSpaceForYou.repo.PostRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("api/post/")
@RestController
public class PostController {

    private final PostRepo postRepo;

    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/")
    public Page<Post> getAllPost(@PageableDefault Pageable pageable) {
        return postRepo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable long id) {
        return postRepo.findById(id);
    }

    @PostMapping("/create")
    public Post createPost(@ModelAttribute Post post) {
        if (post.getDateCreation() == null) {
            post.setDateCreation(LocalDateTime.now());
        }

        return postRepo.save(post);
    }

    @PostMapping("/update")
    public Post updatePost(@ModelAttribute Post post) {
        return postRepo.save(post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable long id) {
        postRepo.deleteById(id);
    }

}
