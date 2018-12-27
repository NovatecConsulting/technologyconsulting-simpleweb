1. clone the repo

2. run in standalone in-memory mode

```bash
git checkout in-memory
mvn -f todobackend spring-boot:run
mvn -f todoui spring-boot:run
```

backend shoud start on port 8080 by default, ui on port 8090

can be specified explicitly through backend.endpoint variable, e.g.


```bash
mvn -f todobackend spring-boot:run -Dserver.port=8081
mvn -f todoui spring-boot:run -Dbackend.endpoint='http://localhost:8081' -Dserver.port=8082
```
