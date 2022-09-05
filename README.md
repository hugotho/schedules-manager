# schedules-manager

## Description

Project developed with the aim of fulfilling the requirements of the first pratice activity proposed in TST-IMD IT residency.

The application proposes to simulate schedules and trial management in TST scope.

### Spring Boot version
`2.7.3`

### System dependencies

#### Java
Java 8 or above
```sh
sudo apt update

sudo apt install openjdk-17-jdk
```

#### Postgresql
```sh
sudo apt -y install postgresql postgresql-contrib

sudo passwd postgres

sudo service postgresql start

sudo -sudo -u postgres psql
# postgres=# CREATE USER your_username WITH ENCRYPTED PASSWORD 'password';
# postgres=# CREATE ROLE your_username;
# postgres=# ALTER ROLE your_username WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;
# postgres=# SET ROLE your_username;
# postgres=# GRANT postgres TO your_username;
# postgres=# CREATE DATABASE schedules_manager ENCODING 'UTF8' TEMPLATE template0 OWNER your_username;
# postgres=# \q

# create env variables
export DB_USERNAME="your_username"
export DB_PASSWORD="password"
``` 

#### Maven
```sh
sudo apt install maven
```
