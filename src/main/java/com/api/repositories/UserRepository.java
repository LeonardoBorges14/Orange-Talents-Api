package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.dto.UserComicListDTO;
import com.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT new com.api.dto.UserComicListDTO(obj) FROM User AS obj Where obj.id=:id")
	UserComicListDTO UserComicList(@Param("id") Long id);
}
