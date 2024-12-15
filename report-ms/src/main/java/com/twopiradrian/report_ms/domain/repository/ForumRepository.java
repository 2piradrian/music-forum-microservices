package com.twopiradrian.report_ms.domain.repository;

import com.twopiradrian.report_ms.domain.entity.Forum;

import java.util.List;

public interface ForumRepository {

    List<Forum> getMonthlyForums(int month, int year);

}
