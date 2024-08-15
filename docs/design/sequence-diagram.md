# Sequence Diagram

A collection of sequence diagrams for all modules in the Trip Together application, illustrating the interactions and
processes within each API.

## Table of Contents

- [Base Sequence](#base-sequence)

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

---