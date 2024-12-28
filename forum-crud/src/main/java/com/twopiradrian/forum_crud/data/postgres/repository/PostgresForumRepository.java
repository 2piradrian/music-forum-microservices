package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostgresForumRepository extends JpaRepository<ForumModel, String> {

    @Query("SELECT f FROM ForumModel f WHERE f.status <> :status ORDER BY f.createdAt DESC")
    Page<ForumModel> findAll(@Param("status") String status, Pageable pageable);

    @Query("SELECT f FROM ForumModel f WHERE f.category = :category AND f.status <> :status ORDER BY f.createdAt DESC")
    Page<ForumModel> findAllByCategory(
            @Param("category") String category,
            @Param("status") String status,
            Pageable pageable
    );

}
