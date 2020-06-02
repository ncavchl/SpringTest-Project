package org.example.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

//Post클래스가 디비에 접근하게 해줄 
public interface PostsRepository extends JpaRepository<Posts, Long>{ // Entity 클래스, PK 타입

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
