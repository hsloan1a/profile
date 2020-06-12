FROM maven:3.6-jdk-14
RUN mkdir -p /profile
WORKDIR /profile/
COPY . /profile/
RUN mvn clean install
