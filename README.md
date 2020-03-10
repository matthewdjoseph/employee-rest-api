Employee REST API
-----------------

This is a simple back-end RESTful API which can be used to store, access, and 
manage a collection of employees. The API is run using the Spring Boot 
Application server that interacts with a MySQL database. 


Getting Started
---------------

Provided you've MySQL installed, run the 'sql scripts\CreateAndFillDB.sql'
file to set the database up and fill it with sample test data that the API 
will access. The sample data is made up of around 20,000 records generated 
using the website https://mockaroo.com/ 

Once the database is created and the employee table is filled, you must add 
a 'application.properties' file in the 'src/main/resources/' directory which
contains the following, replacing the values of spring.datasource.username 
and spring.datasource.password with that of your own MySQL connection:

spring.datasource.url=jdbc:mysql://localhost:3308/company_employees
spring.datasource.username=[MYSQL_USERNAME]
spring.datasource.password=[MYSQL_PASSWORD]
spring.jpa.hibernate.ddl-auto=update

Once the application.properties file is in place you're ready to start the
REST server. In your preferred IDE, run the RestServer.java class in the 
company.employeeRestApi package as a Java application. You can now run the 
StatusController.java class as a Java application to test the status of the 
server.


Accessing API
-------------

This REST API has several different ways of interacting.  There are the GET
requests for getting all active employees in the system, and for getting a 
single employee by a specified id.  There are POST requests for adding a 
single employee, and for updating information on an employee specified by id.
There are also DELETE requests to delete a specified employee or to 
deactivate an employee in the system with the proper credentials.

GET all active employees: http://localhost:8080/
This request returns a list of JSON employee entities:

{
    "id": int,
    "firstName": String,
    "middleInitial": String,
    "lastName": String,
    "dateOfBirth": Date(YYYY-MM-DD),
    "dateOfEmployment": Date(YYYY-MM-DD),
    "status": boolean
}

GET single active employee: http://localhost:8080/employee/{id}
This request returns a single JSON employee entity:

{
    "id": int,
    "firstName": String,
    "middleInitial": String,
    "lastName": String,
    "dateOfBirth": Date(YYYY-MM-DD),
    "dateOfEmployment": Date(YYYY-MM-DD),
    "status": boolean
}

POST add single employee: http://localhost:8080/employee/
This request accepts a JSON entity in the body and returns the employee entity
that was entered into the database:

Body Entity -

{
	"firstName":String,
	"middleInitial":String,
	"lastName":String,
	"dateOfBirth":Date(YYYY-MM-DD),
	"dateOfEmployment":Date(YYYY-MM-DD)
}

POST update single employee: http://localhost:8080/employee/updateEmployee/{id}
This request takes an int URL parameter for the id of the employee to update and
a JSON entity containing the information in which to update:

Body Entity -

{
	"firstName":String,
	"middleInitial":String,
	"lastName":String,
	"dateOfBirth":Date(YYYY-MM-DD),
	"dateOfEmployment":Date(YYYY-MM-DD)
}

DELETE delete single employee: http://localhost:8080/employee/deleteEmployee/{id}
This request deletes a single employee from the system by the provided int URL parameter
used for the employee id.

DELETE deactivate single employee: http://localhost:8080/employee/deactivateEmployee/{id}
This request deactivates a single employee by the provided int URL parameter used for the
employee id.  This request requires Basic Authentication to be attached with the following credentials:

Username - matt
Password - password