## 1. clone the repo

## 2. run in standalone in-memory mode

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

## 3. run in multiple database mode

### A) Run with H2 in-memory database

```bash
git checkout db_profiles
mvn -f todobackend spring-boot:run -Dspring.profiles.active=dev 
mvn -f todoui spring-boot:run 
```

### B) Run with dockerized Postgres DB

```bash
git checkout db_profiles
docker run --name postgresdb -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=matthias -e POSTGRES_DB=mydb -d postgres:latest
mvn -f todobackend spring-boot:run -Dspring.profiles.active=prod 
mvn -f todoui spring-boot:run 
```

Notes:
- Can be specified explicitly through backend.endpoint variable like described in step 2.

## 4. run all components containerized

Build the applciation jars and container images

```bash
mvn -f todobackend clean install
mvn -f todoui clean install
docker build -f Dockerfile-todobackend -t maeddes/todobackend:v1 .
docker build -f Dockerfile-todoui -t maeddes/todoui:v1 .
```

### A) Use Docker Links - (THIS FEATURE IS DEPRECATED!)

In case it is not running start the DB as described in 3B.

Run the container images and set the links to dependent containers.

```bash
docker run --name todobackend -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e SPRING_DATASOURCE_URL='jdbc:postgresql://db:5432/mydb' --link=postgresdb:db maeddes/todobackend:v1

docker run --name todoui -p 8090:8090 -e BACKEND_ENDPOINT='http://todobackend:8080' --link=todobackend:todobackend maeddes/todoui:v1
```

### B) Use Docker Network

clear all containers

```bash
docker network create todonet

docker run --net todonet --name postgresdb -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=matthias -e POSTGRES_DB=mydb -d postgres:latest

docker run --net todonet --name todobackend -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e SPRING_DATASOURCE_URL='jdbc:postgresql://postgresdb.todonet:5432/mydb'  maeddes/todobackend:v1

docker run --net todonet --name todoui -p 8090:8090 -e BACKEND_ENDPOINT='http://todobackend.todonet:8080' --link=todobackend:todobackend maeddes/todoui:v1

docker network inspect todonet
```

## 5. Use docker-compose
