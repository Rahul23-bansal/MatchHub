# MatchHub
A project that gives all the required details about matches, teams and it's players.

Prerequisites: 
Before running the application, ensure you have the following installed:
1. Java Development Kit (JDK) 8 or higher
2. Maven (if not using an IDE that supports Maven)
3. MySQL Server (or another database supported by Spring Boot) (We have used local MySQL database in our project)

Configure the database connection:
1. Ensure MySQL Server is running.
2. Update the application.properties file located in src/main/resources with your database connection details:
  spring.datasource.url=jdbc:mysql://<mysql-host>:3306/matchhub
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Replace <mysql-host> with your MySQL server host address. If running locally, you can use localhost.

THE TABLE STRUCTURE IS FORMED USING THESE FOLLOWING THREE ENTITIES:
1. MatchEntity Table:

The MatchEntity class corresponds to the matches table.
It has columns for id, teamEntity1, teamEntity2, date, venue, playerOfTheMatch, resultType, and winningTeam.
id is the primary key and is auto-generated.
teamEntity1 and teamEntity2 columns represent many-to-one relationships with the TeamEntity table.
playerOfTheMatch column represents a many-to-one relationship with the PlayerEntity table.
resultType column stores an enumerated type ResultType.
winningTeam column represents a many-to-one relationship with the TeamEntity table.

2. TeamEntity Table:

The TeamEntity class corresponds to the teams table.
It has columns for id, name, matches, PlayingX1, wins, and loses.
id is the primary key and is auto-generated.
name column stores the name of the team.
matches column represents a one-to-many relationship with the MatchEntity table.
PlayingX1 column represents a many-to-many relationship with the PlayerEntity table.
wins and loses columns store the count of wins and loses for the team, respectively.

3. PlayerEntity Table:

The PlayerEntity class corresponds to the player table.
It has columns for id and name.
id is the primary key and is auto-generated.
name column stores the name of the player.
teams column represents a many-to-many relationship with the TeamEntity table.
These relationships are defined using JPA annotations such as @ManyToOne, @OneToMany, and @ManyToMany, along with appropriate column definitions like @Id, @GeneratedValue, and @Enumerated. These annotations guide the JPA provider (like Hibernate) to create and manage the database tables and their relationships based on the defined entity classes.

SWAGGER INTEGRATION
This project also integrates Swagger for API documentation and testing.
Once the application is running, you can access the Swagger UI through:
  http://localhost:8080/swagger-ui.html

Swagger provides a user-friendly interface to view and test the APIs.
It also generates sample test cases based on the API specifications.

Once the application is running, you can access it through:
  http://localhost:8080

