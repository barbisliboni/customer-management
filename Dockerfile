FROM maven:3.8.6-openjdk-11
COPY . /usr/src/customer
WORKDIR /usr/src/customer
RUN mvn clean install
CMD ["mvn","spring-boot:run"]