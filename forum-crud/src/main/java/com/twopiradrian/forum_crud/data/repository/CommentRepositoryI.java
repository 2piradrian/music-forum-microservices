package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.PostgresCommentRepository;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CommentRepositoryI implements CommentRepository {

    private final PostgresCommentRepository commentRepository;

    @Override
    public Comment getById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
