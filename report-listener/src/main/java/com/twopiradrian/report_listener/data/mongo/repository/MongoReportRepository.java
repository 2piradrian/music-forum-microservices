package com.twopiradrian.report_listener.data.mongo.repository;

import com.twopiradrian.report_listener.data.mongo.model.ReportModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoReportRepository extends MongoRepository<ReportModel, String> {

}
