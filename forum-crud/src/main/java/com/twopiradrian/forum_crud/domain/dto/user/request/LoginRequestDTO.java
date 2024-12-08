package com.twopiradrian.forum_crud.domain.dto.user.request;

import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import com.twopiradrian.forum_crud.domain.validator.RegexValidators;
import lombok.Getter;

@Getter
public class LoginRequestDTO {

    private final String email;

    private final String password;

    private LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginRequestDTO create(String email, String password) {

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

        return new LoginRequestDTO(email, password);
    }

}
