package com.twopiradrian.auth_server.domain.dto.user.request;

import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.domain.error.ErrorType;
import com.twopiradrian.auth_server.domain.validator.RegexValidators;
import lombok.Getter;

@Getter
public class CredentialsLoginUserReq {

    private final String email;

    private final String password;

    private CredentialsLoginUserReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static CredentialsLoginUserReq create(String email, String password) {

        if (password == null || email == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (password.isEmpty() || email.isEmpty()) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        RegexValidators passwordValidator = RegexValidators.PASSWORD;
        if (!password.matches(passwordValidator.getRegex())) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        RegexValidators emailValidator = RegexValidators.EMAIL;
        if (!email.matches(emailValidator.getRegex())) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new CredentialsLoginUserReq(email, password);
    }

}
