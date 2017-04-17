package org.egov.user.web.adapters.errors;

import org.egov.common.contract.response.Error;
import org.egov.common.contract.response.ErrorField;
import org.egov.common.contract.response.ErrorResponse;
import org.egov.user.domain.model.User;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class UserNotFoundErrorHandler implements ErrorAdapter<User> {

    private static final String USER_NOT_FOUND_CODE = "USER.USER_NOT_FOUND";
    private static final String USER_NOT_FOUND_MESSAGE = "User not found";
    private static final String USER_ID_FIELD = "User.id";

    public ErrorResponse adapt(final User user) {
        final Error error = getError();
        return new ErrorResponse(null, error);
    }

    private Error getError() {
        return Error.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(USER_NOT_FOUND_MESSAGE)
                .fields(getUserNameFieldError())
                .build();
    }

    private List<ErrorField> getUserNameFieldError() {
        return Collections.singletonList(
                ErrorField.builder()
                        .field(USER_ID_FIELD)
                        .code(USER_NOT_FOUND_CODE)
                        .message(USER_NOT_FOUND_MESSAGE)
                        .build()
        );
    }
}
