# Response Code

A collection of response codes and statuses for all modules in the Trip Together application.

## Table of Contents

- [Successful Responses](#successful-responses)
- [Client Error Responses](#client-error-responses)
- [Server Error Responses](#server-error-responses)

---

## Successful Responses

This section contains response codes indicating successful operations within the application.

### 200 Success

|   Code    |  Status   | Description |
|:---------:|:---------:|:------------|
| `200-000` | `SUCCESS` | OK.         |

### 201 Created

|   Code    |     Status     | Description                      |
|:---------:|:--------------:|:---------------------------------|
| `201-001` | `USER_CREATED` | User has successfully signed up. |

---

## Client Error Responses

This section contains response codes indicating errors caused by the client's input or actions.

### 400 Bad Request

|   Code    |        Status         | Description                  |
|:---------:|:---------------------:|:-----------------------------|
| `400-000` |     `BAD_REQUEST`     | Invalid request.             |
| `400-101` | `USERNAME_DUPLICATED` | Username is already in used. |
| `400-102` |  `EMAIL_DUPLICATED`   | Email is already in used.    |

### 401 Unauthorized

|   Code    |         Status         | Description              |
|:---------:|:----------------------:|:-------------------------|
| `401-001` |   `NO_ACCESS_TOKEN`    | Access token not found.  |
| `401-002` | `INVALID_ACCESS_TOKEN` | Invalid access token.    |
| `401-003` | `ACCESS_TOKEN_EXPIRED` | Access token is expired. |

### 403 Forbidden

|   Code    |        Status         | Description                  |
|:---------:|:---------------------:|:-----------------------------|
|           |                       |                              |

### 404 Not Found

|   Code    |        Status         | Description                  |
|:---------:|:---------------------:|:-----------------------------|
|           |                       |                              |

---

## Server Error Responses

This section contains response codes indicating errors that occur on the server side.

### 500 Internal Server Error

|   Code    |         Status          | Description                                                         |
|:---------:|:-----------------------:|:--------------------------------------------------------------------|
| `500-000` | `INTERNAL_SERVER_ERROR` | An unexpected error occurred on the server. Please try again later! |

---