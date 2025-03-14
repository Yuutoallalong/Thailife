DROP DATABASE IF EXISTS "MockupDB";

CREATE DATABASE "MockupDB"
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'th_TH.UTF-8'
    LC_CTYPE = 'th_TH.UTF-8'
    TEMPLATE = template0;

SELECT current_database();

DROP TABLE IF EXISTS policy_master;

CREATE TABLE policy_master (
    "policyNo" VARCHAR(255) NOT NULL,
    "policyType" VARCHAR(255),
    "status" VARCHAR(255),
    "agenID" VARCHAR(255),
    "insureName" VARCHAR(255)
);


-- INSERT INTO policy_master ("policyNo", "policyType", "status", "agenID", "insureName") VALUES
-- ('P00031', 'CL', 'A', '00000005', 'นายA1'),
-- ('P00032', 'HL', 'E', '00000006', 'นายB2'),
-- ('P00033', 'TL', 'A', '00000007', 'นายC3');

INSERT INTO policy_master ("policyNo", "policyType", "status", "agenID", "insureName")
VALUES 
('P00031', 'CL', 'A', '00000005', E'\u0e19\u0e32\u0e22A1'),
('P00032', 'HL', 'E', '00000006', E'\u0e19\u0e32\u0e22B2'),
('P00033', 'TL', 'A', '00000007', E'\u0e19\u0e32\u0e22C3');


SELECT * FROM policy_master;

-- SELECT datname, encoding, datcollate, datctype
-- FROM pg_database
-- WHERE datname = 'MockupDB';

-- SELECT "insureName", encode("insureName"::bytea, 'hex') AS hex_value
-- FROM policy_master;

-- SELECT "insureName", encode("insureName"::bytea, 'hex') 
-- FROM policy_master;

-- SELECT "insureName"
-- FROM policy_master
-- WHERE encode("insureName"::bytea, 'hex') = 'e0b899e0b8b2e0b8a24131';

-- SHOW SERVER_ENCODING;
-- SHOW LC_COLLATE;
-- SHOW LC_CTYPE;

-- SELECT datname, encoding FROM pg_database WHERE datname = 'MockupDB';

-- SELECT "insureName", encode("insureName"::bytea, 'hex') FROM policy_master;

-- SELECT "insureName" FROM policy_master WHERE "insureName" = 'นายA1';

-- VACUUM FULL;
-- ANALYZE;
