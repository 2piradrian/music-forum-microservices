package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.CommentEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresCommentRepository;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.entity.Status;
import com.twopiradrian.forum_crud.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CommentRepositoryI implements CommentRepository {

    private final PostgresCommentRepository commentRepository;

    @Override
    public Comment getById(String commentId) {
        CommentModel commentModel = this.commentRepository.findById(commentId).orElse(null);

        if (commentModel == null) {
            return null;
        }

        if (commentModel.getStatus().equals(Status.DELETED)) {
            commentModel.setAuthorId(Status.DELETED.toString());
            commentModel.setContent(Status.DELETED.toString());

            return CommentEntityMapper.toDomain(commentModel);
        }

        return CommentEntityMapper.toDomain(commentModel);
    }

    @Override
    public Comment save(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        CommentModel saved = this.commentRepository.save(commentModel);

        return CommentEntityMapper.toDomain(saved);
    }

    @Override
    public Comment update(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        CommentModel updated = this.commentRepository.save(commentModel);

        return CommentEntityMapper.toDomain(updated);
    }

}
