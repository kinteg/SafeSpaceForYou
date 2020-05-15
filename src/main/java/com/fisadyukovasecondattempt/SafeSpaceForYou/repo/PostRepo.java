package com.fisadyukovasecondattempt.SafeSpaceForYou.repo;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

    Post findById(long id);

    Page<Post> findAll(Pageable pageable);

}
