package com.twopiradrian.report_ms.domain.repository;

import com.twopiradrian.entity.Forum;

import java.util.List;

public interface ForumRepository {

    List<Forum> getMonthlyForums(Integer month, Integer year);

}
