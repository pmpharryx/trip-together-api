# Sequence Diagram

A collection of sequence diagrams for all modules in the Trip Together application, illustrating the interactions and
processes within each API.

## Table of Contents

- [Base Sequence](#base-sequence)
- [Module 1 - User Management](#module-1---user-management)
    - [Module 1.1 - Authentication](#module-11---authentication)

---

## Base Sequence

- Base sequence is the required sequences which are included in all sequence diagrams.

```mermaid
sequenceDiagram
    autonumber

    actor CLI as Client
    participant CR as Controller
    participant FT_AUTH as AuthenticationFilter
    participant UT_JWT as JwtUtility
    participant VL as Validator
    participant SV as Service

    CLI->>CR: {httpMethod} /{apiVersion}/{feature}/{endpoint}
    activate CR
        opt Authorization is required
            CR->>FT_AUTH: Authorize request access token
            activate FT_AUTH
                break Header <authorization> is not found
                    FT_AUTH->>CLI: Return <401-001, NO_ACCESS_TOKEN>
                end
                FT_AUTH->>UT_JWT: Verify JWT access token
                activate UT_JWT
                    break <access_token> is invalid
                        UT_JWT->>FT_AUTH: Return JWT verification exception
                        FT_AUTH->>CLI: Return <401-002, INVALID_ACCESS_TOKEN>
                    end
                    break <access_token> is expired
                        UT_JWT->>FT_AUTH: Return JWT verification exception
                        FT_AUTH->>CLI: Return <401-003, ACCESS_TOKEN_EXPIRED>
                    end
                    UT_JWT->>FT_AUTH: Return <jwt_data>
                deactivate UT_JWT
            deactivate FT_AUTH
        end
        CR->>VL: Validate request body
        activate VL
            break Invalid field is found
                VL->>CR: Return result
                deactivate VL
                CR->>CLI: Return <400-000, BAD_REQUEST>
            end
        break Unexpected error is found
            SV->>CLI: Return <500-000, INTERNAL_SERVER_ERROR>
        end
    deactivate CR
```

## Module 1 - User Management

### Module 1.1 - Authentication

- **Sign Up**: Sign up a new user in the system.

```mermaid
sequenceDiagram
    autonumber
    
    actor CLI as Client
    participant CR_AUTH as AuthController
    participant SV_AUTH as AuthService
    participant UT_HASHING as HashingUtility
    participant RP_AUTH as AuthRepository
    participant DB_USER as Database <br> <<Users>>

    CLI->>CR_AUTH: POST /v1/auth/sign-up
    activate CR_AUTH
        CR_AUTH->>SV_AUTH: Send request to sign up service
        activate SV_AUTH
            SV_AUTH->>RP_AUTH: Find <User> by <username>
            activate RP_AUTH
                RP_AUTH->>DB_USER: Get <User> by <username>
                activate DB_USER
                    DB_USER->>RP_AUTH: Return result
                deactivate DB_USER
                RP_AUTH->>SV_AUTH: Return <User>
                break <User> with <username> is found
                    SV_AUTH->>CLI: Return <400-101, USERNAME_DUPLICATED>
                end
                SV_AUTH->>RP_AUTH: Find <User> by <email>
                RP_AUTH->>DB_USER: Get <User> by <email>
                activate DB_USER
                    DB_USER->>RP_AUTH: Return result
                deactivate DB_USER
                RP_AUTH->>SV_AUTH: Return <User>
                break <User> with <email> is found
                    SV_AUTH->>CLI: Return <400-102, EMAIL_DUPLICATED>
                end
                SV_AUTH->>UT_HASHING: Hash <password>
                activate UT_HASHING
                    UT_HASHING->>SV_AUTH: Return <hashed_password>
                deactivate UT_HASHING
                SV_AUTH->>RP_AUTH: Save new <User> data
                RP_AUTH->>DB_USER: Create new <User> record
                activate DB_USER
                    DB_USER-->>RP_AUTH: Return result
                deactivate DB_USER
                RP_AUTH-->>SV_AUTH: Return <User>
            deactivate RP_AUTH
            SV_AUTH-->>CR_AUTH: Return success response
        deactivate SV_AUTH
        CR_AUTH-->>CLI: Return <201-001, USER_CREATED>
    deactivate CR_AUTH
```

---