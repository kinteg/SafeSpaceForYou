package com.fisadyukovasecondattempt.SafeSpaceForYou.service.impl;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.Post;
import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.CreatePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.SimplePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.UpdatePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.repo.PostRepo;
import com.fisadyukovasecondattempt.SafeSpaceForYou.repo.UserRepo;
import com.fisadyukovasecondattempt.SafeSpaceForYou.security.jwt.JwtUser;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Page<SimplePostDto> getAllPost(Pageable pageable) {
        Page<Post> posts = postRepo.findAll(pageable);
        List<SimplePostDto> content = posts.getContent()
                .stream().map(SimplePostDto::toSimplePost).collect(Collectors.toList());

        return new PageImpl<>(content, posts.getPageable(), content.size());
    }

    @Override
    public SimplePostDto getPost(Long id) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        return SimplePostDto.toSimplePost(post);
    }

    @Override
    public SimplePostDto createPost(CreatePostDto createPostDto) {
        Post post = createPostDto.toPost();

        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepo.findById(jwtUser.getId()).orElseThrow(() -> new AuthorizationServiceException(""));
        post.setUser(user);

        postRepo.save(post);

        return SimplePostDto.toSimplePost(post);
    }

    @Override
    public SimplePostDto updatePost(UpdatePostDto updatePostDto) {
        Post post = postRepo.findById(updatePostDto.getId())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        post.setMainText(updatePostDto.getMainText());
        post.setTitle(updatePostDto.getTitle());

        postRepo.save(post);

        return SimplePostDto.toSimplePost(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

}
