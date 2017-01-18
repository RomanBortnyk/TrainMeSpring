#TrainMe

Service which provides easy hiring of coaches, communication between coaches(sport instructors) and their clients. Feedback and search systems helps to find the best coach for client's requirements. Messenger provides an opportunity to users to communicate. Technology stack: Spring(MVC, Security), JSP, Bootstrap, Hibernate, WebSockets, AJAX, REST.

##Demonstration video
[![IMAGE ALT TEXT HERE](https://www.youtube.com/vi/MZe95N9O8FU/0.jpg)](https://www.youtube.com/watch?v=MZe95N9O8FU)

##Getting started
###Requirements:
1. Servlet container which supports Servlet 3.0
2. JDK 1.8
3. Maven 
4. MySQL database

###Steps:
1. Clone this repository
2. Use database script in src/main/resources/TrainMe.sql and generate the database
3. Edit DataSource bean in RootConfig if it needed
4. Deploy project to your local server

###Steps with Docker:
1. Build the docker image from the above Dockerfile using this command 
`sudo docker build -f Dockerfile -t demo`
2. Create a Dockerfile with following content:
`FROM tomcat:8`,
`ADD target/*.war /usr/local/tomcat/webapps/`
3. Build and package and the project:
`sudo docker run -it --rm -v "$PWD":/app -w /app demo mvn clean install`
4. Build the Dockerfile:
`sudo docker build -f Dockerfile -t demo/tomcat:8 .`
5. Run the application by executing this command: 
`bash $ docker run --rm -p 8080:8080 demo/tomcat:8`
