FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD password

ENV MYSQL_DATABASE userDatabase

ENV MYSQL_USER sqluser

ENV MYSQL_PASSWORD password

ADD initial-setup.sql /docker-entrypoint-initdb.d

EXPOSE 3306
