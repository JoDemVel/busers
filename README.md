# Busers
Backend to manage users, roles and permissions (Project for a diploma module, does not include authentication or good practices for real user management)

### Prerequisites
* Java 21
* Maven
* Postgres

-------------------
Before to run the database change connection db parameter.
In my case is:
```
url: jdbc:postgresql://localhost:5432/dev_busers
username: jodemvel
password: postgres
```
Also create Databases
* busers
* dev_busers
* qa_busers
* staging_busers
* prod_busers

-------------------
## You can see all services (API Endpoints) implemented on this swagger url
http://localhost:8080/swagger-ui/index.html
