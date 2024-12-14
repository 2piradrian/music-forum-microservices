package com.twopiradrian.forum_crud_fallback.data.repository;

import com.twopiradrian.forum_crud_fallback.data.postgres.mapper.CommentEntityMapper;
import com.twopiradrian.forum_crud_fallback.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud_fallback.data.postgres.repository.PostgresCommentRepository;
import com.twopiradrian.forum_crud_fallback.domain.entity.Comment;
import com.twopiradrian.forum_crud_fallback.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CommentRepositoryI implements CommentRepository {

    private final PostgresCommentRepository commentRepository;

    @Override
    public Comment getById(Long commentId) {
        CommentModel commentModel = commentRepository.findById(commentId).orElse(null);
        return commentModel != null ? CommentEntityMapper.toDomain(commentModel) : null;
    }

}
