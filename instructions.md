1. clone the repo

2. run in standalone in-memory mode

```bash
git checkout in_memory
mvn -f todobackend spring-boot:run
mvn -f todoui spring-boot:run
```

backend shoud start on port 8080 by default, ui on port 8090

can be specified explicitly through backend.endpoint variable, e.g.

```bash
mvn -f todobackend spring-boot:run -Dserver.port=8081
mvn -f todoui spring-boot:run -Dbackend.endpoint='http://localhost:8081' -Dserver.port=8082
```

3. run in multiple database mode

A) Run with H2 in-memory database

```bash
git checkout db_profiles
mvn -f todobackend spring-boot:run -Dspring.profiles.active=dev 
mvn -f todoui spring-boot:run 
```

B) Run with dockerized Postgres DB

```bash
git checkout db_profiles
docker run --name postgresdb -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=matthias -e POSTGRES_DB=mydb -d postgres:latest
mvn -f todobackend spring-boot:run -Dspring.profiles.active=prod 
mvn -f todoui spring-boot:run 
```

Notes:
- Can be specified explicitly through backend.endpoint variable like described in step 2.

