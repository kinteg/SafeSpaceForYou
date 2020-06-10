package com.fisadyukovasecondattempt.SafeSpaceForYou.controller;

import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.CreatePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.SimplePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.UpdatePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RequestMapping("api/post/")
@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<SimplePostDto>> getAllPost(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(postService.getAllPost(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimplePostDto> getPost(@NotNull @Min(0) @PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimplePostDto> createPost(@Valid @RequestBody CreatePostDto post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @PostMapping("/update")
    public ResponseEntity<SimplePostDto> updatePost(@ModelAttribute UpdatePostDto post) {
        return ResponseEntity.ok(postService.updatePost(post));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@NotNull @Min(0) @PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("");
    }

}
