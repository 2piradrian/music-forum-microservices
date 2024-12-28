package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.ForumEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresForumRepository;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.PageContent;
import com.twopiradrian.forum_crud.domain.entity.Status;
import com.twopiradrian.forum_crud.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final PostgresForumRepository forumRepository;

    @Override
    public Forum getById(String forumId) {
        ForumModel forumModel = this.forumRepository.findById(forumId).orElse(null);

        if (forumModel == null) {
            return null;
        }

        if (forumModel.getStatus().equals(Status.DELETED)) {
            return null;
        }

        return ForumEntityMapper.toDomain(forumModel);
    }

    @Override
    public PageContent<Forum> getAllForums(Integer page, Integer size, String category) {
        Page<ForumModel> forumModels;
        if (category != null) {
            forumModels
                    = this.forumRepository.findAllByCategory(
                            category, Status.DELETED.toString(), PageRequest.of(page, size)
            );
        }
        else {
            forumModels
                    = this.forumRepository.findAll(
                            Status.DELETED.toString(), PageRequest.of(page, size)
            );
        }

        return new PageContent<Forum>(
                forumModels.getContent().stream().map(ForumEntityMapper::toDomain).collect(Collectors.toList()),
                forumModels.getNumber(),
                forumModels.hasNext() ? forumModels.getNumber() + 1 : null
        );
    }

    @Override
    public List<Forum> getMonthlyForums(int month, int year) {
        List<ForumModel> forumModels = this.forumRepository.getMonthlyForums(
                month, year, Status.DELETED.toString()
        );

        return forumModels.stream().map(ForumEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Forum save(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        ForumModel saved = this.forumRepository.save(forumModel);

        return ForumEntityMapper.toDomain(saved);
    }

    @Override
    public Forum update(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        ForumModel updated = this.forumRepository.save(forumModel);

        return ForumEntityMapper.toDomain(updated);
    }

}
