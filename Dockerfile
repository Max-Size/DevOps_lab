FROM openjdk
COPY /src/main/java /java
WORKDIR /java
RUN javac packagename/Main.java
RUN javac packagename/Person.java
CMD ["java","packagename.Main"]

