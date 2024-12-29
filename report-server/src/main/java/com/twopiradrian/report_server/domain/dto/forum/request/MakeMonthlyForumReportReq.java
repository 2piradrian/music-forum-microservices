package com.twopiradrian.report_server.domain.dto.forum.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class MakeMonthlyForumReportReq {

    private final int month;
    private final int year;

    private MakeMonthlyForumReportReq(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public static MakeMonthlyForumReportReq create(int month, int year) {

        if (month < 1 || month > 12) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new MakeMonthlyForumReportReq(month, year);
    }

}
