package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
