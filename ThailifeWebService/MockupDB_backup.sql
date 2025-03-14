--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: th_TH.UTF-8; Type: COLLATION; Schema: public; Owner: postgres
--

CREATE COLLATION public."th_TH.UTF-8" (provider = libc, locale = 'th_TH.UTF-8');


ALTER COLLATION public."th_TH.UTF-8" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: policy_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.policy_master (
    "policyNo" character varying(255) NOT NULL,
    "policyType" character varying(255),
    status character varying(255),
    "agenID" character varying(255),
    "insureName" character varying(255) COLLATE public."th_TH.UTF-8"
);


ALTER TABLE public.policy_master OWNER TO postgres;

--
-- Data for Name: policy_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.policy_master ("policyNo", "policyType", status, "agenID", "insureName") FROM stdin;
P00031	CL	A	00000005	นายA1
P00032	HL	E	00000006	นายB2
P00033	TL	A	00000007	นายC3
\.


--
-- PostgreSQL database dump complete
--

