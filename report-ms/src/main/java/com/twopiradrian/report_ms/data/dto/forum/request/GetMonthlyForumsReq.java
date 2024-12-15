package com.twopiradrian.report_ms.data.dto.forum.request;

import com.twopiradrian.report_ms.domain.error.ErrorHandler;
import com.twopiradrian.report_ms.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class GetMonthlyForumsReq {

    private final int month;
    private final int year;

    private GetMonthlyForumsReq(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public static GetMonthlyForumsReq create(int month, int year) {

        if (month < 1 || month > 12) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetMonthlyForumsReq(month, year);
    }

}
