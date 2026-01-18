CREATE TABLE credit_applications (
    id BIGSERIAL PRIMARY KEY,
    credit_amount BIGINT NOT NULL,
    term_months INT NOT NULL,
    income BIGINT NOT NULL,
    current_credit_load BIGINT NOT NULL,
    credit_rating INT NOT NULL,
    status VARCHAR(32) NOT NULL
);