## Getting Started


### Prerequisites

An IDE is needed to build and compile maven project, ideally Intellij Idea. A MySQL database is needed to run the database.

### Installing

Clone the repository using the command `git clone https://github.com/Raman077/YourJobsite.git`

Open the project using Intellij Idea or any IDE having maven and SpringBoot support. Wait for the files to be imported to the IDE. If required, set the java SDK version as 1.8

Open MySQL database and create a database called springbootdb.

In the IDE from the root folder, run the command `mvn clean install`.

### Running the project

Once the project has been successfully built, run the command `mvn spring-boot:run`

On the MySQL database, three tables will be created. We are concerned with the user table and the company table. Go to the user table and create custom Users and do the same for the company table.

On any web browser, open the link `localhost:8090`. You will be redirected to the login page. Enter the user credentials that you have provided in the database and hit login. You will be redirected to the welcome page. Hit the company name and you will be redirected to the company page.

## To Do

- [ ] Add user profile picture and company profile picture to the database and display it on the page.
- [ ] Show the active number of viewers currently viewing the page.
- [ ] Add registration route.




