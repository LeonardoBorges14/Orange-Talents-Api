package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.entities.Comic;

public interface ComicRepository extends JpaRepository<Comic, Long>{

}
