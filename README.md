# Thailife Technical Test Submission

This repository contains solutions to the technical test for Thailife. The project includes SQL queries, Java web service implementation using Gradle, and function-related logic.

Already include some picture of  results, but can run it yourself to check
I use most time to fix encoding issues to make datacase and java can read "นายA1" in input correctly.
---

## Setup Instructions

### Step 1: Install Dependencies
- PostgreSQL (For database setup)
- Java 21 (LTS) (For running the Java Web Service)
- Gradle (For project build and dependency management)
- VS Code (Recommended IDE) or any preferred IDE

---

### Step 2: Database Setup
1. Open PostgreSQL and create the database:
   ```sql
   CREATE DATABASE DBCorebiz;
   CREATE DATABASE MockupDB;
   ```
2. Import the provided SQL file:
   ```sql
   \i path/to/DBCorebiz.sql
   ```
3. For the Mockup Database:
   ```sql
   \i path/to/MockupDB_backup.sql
   ```

---

### Step 3: Web Service Setup
1. Navigate to the `ThailifeWebService` folder.
2. Update the `application.properties` file with your database credentials:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/MockupDB
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. Build and run the web service using Gradle:
   ```
   ./gradlew bootRun
   ```

---

### Step 4: Testing the Web Service
- Use Postman or a web browser to test the endpoints.
- Example endpoint(nedd to use"insureName": "\u0e19\u0e32\u0e22A1" instead of "insureName": "นายA1" due to encoding issue i can't fix rightnow. ;-;):
  ```
  POST http://localhost:8080/api/getPolicyInfo

  Header: Content-Type : application/json
  Body: raw json
  {
   "headerData": {
       "messageId": "123456",
       "sentDateTime": "2025-03-13 10:30:59"
   },
   "requestRecord": {
      "insureName": "\u0e19\u0e32\u0e22A1"
   }
   }
  ```

---

### Step 5: SQL Query Instructions
1. Open PostgreSQL.
2. Run the provided queries from `SQLprob/.sql`.
3. Example query to find policies with `PartnerCode = 071.xxx`:
   ```sql
   SELECT *
   FROM partnerbenefit.benefit_master
   WHERE partner_code LIKE '071.%';

   SELECT *
   FROM partnerbenefit.benefit_master
   WHERE policy_status_date >= '2020-01-01'
   AND policy_status_date <= '2020-12-31';

   SELECT *
   FROM partnerbenefit.benefit_master
   WHERE sum BETWEEN 100000 AND 500000;
   ```

---


