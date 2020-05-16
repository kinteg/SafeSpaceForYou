package com.fisadyukovasecondattempt.SafeSpaceForYou.repo;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Long> {

    User findByUsername(String userName);

}
