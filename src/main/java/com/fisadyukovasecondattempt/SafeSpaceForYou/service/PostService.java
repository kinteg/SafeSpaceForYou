package com.fisadyukovasecondattempt.SafeSpaceForYou.service;

import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.CreatePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.SimplePostDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.UpdatePostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Page<SimplePostDto> getAllPost(Pageable pageable);

    SimplePostDto getPost(Long id);

    SimplePostDto createPost(CreatePostDto post);

    SimplePostDto updatePost(UpdatePostDto post);

    void deletePost(Long id);

}
