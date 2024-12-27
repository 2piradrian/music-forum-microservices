package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.CommentEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresCommentRepository;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CommentRepositoryI implements CommentRepository {

    private final PostgresCommentRepository commentRepository;

    @Override
    public Comment getById(String commentId) {
        CommentModel commentModel = commentRepository.findById(commentId).orElse(null);
        return commentModel != null ? CommentEntityMapper.toDomain(commentModel) : null;
    }

    @Override
    public void save(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        commentRepository.save(commentModel);
    }

    @Override
    public void update(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        commentRepository.save(commentModel);
    }

    @Override
    public void deleteById(String commentId) {
        commentRepository.deleteById(commentId);
    }

}
