FROM openjdk:11
WORKDIR /app/
COPY src ./src
RUN javac -sourcepath src ./src/Process.java -Xlint:unchecked -d ./
