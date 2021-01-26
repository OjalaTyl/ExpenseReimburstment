# Expense Reimbursement System
## Project Description:
Expense Reimbursement System The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can log in and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies and Integrated Development Environments Used:
* Java
* Spring Tool Suite
* HTML
* CSS
* JavaScript
* Tomcat
* Postgres
* DBeaver

## Features:
* Employees and managers can login and logout.
* Employees can submit expense reimburstment tickets.
* Employees can view their past tickets.
* Managers can approve or deny tickets.
* Managers can see all past tickets.
* All data is persisted within a postgres database.
* Users interact with the program through an HTML webpage styled using CSS and Bootstrap.

## Getting Started
* First do git clone https://github.com/2012JavaReston/ExpenseReimbursement-Project-1.git
* Ensure you have Java 1.8 and Tomcat 8.5 installed on your environment.
* Create an AWS Postgresql RDS instance to host the database on
* From here open the project in your preffered IDE.
* Navigate to the file /Project_1/src/main/java/Connections/Connector.java 
* Edit the connection and your environment variables to connect to your own RDS instance.
* Launch to program onto the Tomcat server and open postman.
* Utilize postman to populate the database with users and managers.
* Now open your web browser and go to localhost:8080//Project2
* You should now be in the program with users setup.

## Usage
* When logged in as an employee you can see your past tickets.
* While logged in you can submit a new ticket by filling out the form above your past tickets.
* When logged in as a manager you can see all past tickets.
* As a manager you can still make tickets, also you can approve or deny tickets below all tickets by entering the ticket id then pressing apporve or deny.
