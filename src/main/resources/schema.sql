CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    mobile_no VARCHAR(15) NOT NULL UNIQUE,
    created_by VARCHAR(255) NOT NULL DEFAULT 'System',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) DEFAULT 'System',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
