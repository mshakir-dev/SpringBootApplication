### Database

1. show databases;
2. create database mshakir;
3. show tables;

create user 'mshakir93'@'localhost' identified by 'mcleod_software';
grant all privileges on mcleod_software.* to 'mshakir93'@'localhost';
flush privileges;

### Steps To Create a Restful Web Service
1. First Create a Restful Controllers.
2. Update Pom File ( Added Dependencies -  Mysql Connector and Spring Data JPA)
3. Update Java Version to 8
4. Update Application.Properties File to configure the Database

```
spring.datasource.username=mshakir93
spring.datasource.password=mcleod_software
spring.datasource.url=jdbc:mysql://localhost:3306/mcleod_software
spring.jpa.hibernate.ddl-auto=update
```