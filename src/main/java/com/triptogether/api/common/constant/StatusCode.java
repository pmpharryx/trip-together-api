package com.triptogether.api.common.constant;

public final class StatusCode {
    // 200 Success
    public static final String SUCCESS = "200-000";

    // 201 Created
    public static final String USER_CREATED = "201-001";

    // 400 Bad Request
    public static final String BAD_REQUEST = "400-000";
    public static final String USERNAME_DUPLICATED = "400-101";
    public static final String EMAIL_DUPLICATED = "400-102";

    // 401 Unauthorized
    public static final String NO_ACCESS_TOKEN = "401-001";
    public static final String INVALID_ACCESS_TOKEN = "401-002";
    public static final String ACCESS_TOKEN_EXPIRED = "401-003";


    // 404 Not Found
    public static final String NOT_FOUND = "404-000";

    // 500 Internal Server Error
    public static final String INTERNAL_SERVER_ERROR = "500-000";


}
