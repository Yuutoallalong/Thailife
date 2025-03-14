CREATE DATABASE "MockupDB"
  WITH OWNER = postgres
  ENCODING = 'UTF8'
  LC_COLLATE = 'th_TH.UTF-8'
  LC_CTYPE = 'th_TH.UTF-8'
  TEMPLATE = template0;


DROP DATABASE IF EXISTS "MockupDB";


SELECT current_database();

CREATE TABLE policy_master (
    "policyNo" VARCHAR(255) NOT NULL,
    "policyType" VARCHAR(255),
    "status" VARCHAR(255),
    "agenID" VARCHAR(255),
    "insureName" VARCHAR(255)
);


INSERT INTO policy_master ("policyNo", "policyType", "status", "agenID", "insureName") VALUES
('P00031', 'CL', 'A', '00000005', 'นายA1'),
('P00032', 'HL', 'E', '00000006', 'นายB2'),
('P00033', 'TL', 'A', '00000007', 'นายC3');

SELECT * FROM policy_master;

-- SELECT datname, encoding, datcollate, datctype
-- FROM pg_database
-- WHERE datname = 'MockupDB';

-- SELECT "insureName", encode("insureName"::bytea, 'hex') AS hex_value
-- FROM policy_master;
