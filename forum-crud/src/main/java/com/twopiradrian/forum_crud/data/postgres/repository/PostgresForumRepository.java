package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresForumRepository extends JpaRepository<ForumModel, String> {

    Page<ForumModel> findAllByStatusNotAndOrderByCreatedAtDesc(String status, Pageable pageable);

    Page<ForumModel> findAllByCategoryAndStatusNotAndOrderByCreatedAtDesc(String category, String status, Pageable pageable);

    Page<ForumModel> findAllByCategoryAndStatusNotAndOrderByUpdatedAtDesc(String category, String status, Pageable pageable);

}
