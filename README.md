Coverage: 80%
# QA - Inventory Management System Project

This project was undertaken to meet the specification underlined by QA as part of training. The project requires the creation of a Database using MySQL, which stores data about customers, items, and the orders that they can place. This database should then be accessible through a Java application, and this application should allow users to perform CRUD operations on the database through a Java CLI. The project was initially provided as a template and specification and required the addition of various classes in Java, as well as tables in MySQL, and supporting documentation for both.

## Getting Started


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Below is a list of applications/tools required to both run and develop this project.

```
- Java 8 (https://www.oracle.com/java/technologies/downloads/#java8)
Guide on how to install Java provided by Oracle (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

- MySQL 8 (https://dev.mysql.com/downloads/windows/installer/8.0.html)
Guide from MySQL site (https://dev.mysql.com/doc/refman/8.0/en/installing.html)*
* Note that we need MySQL Server and MySQL Workbench for hosting a database and running queries

- Eclipse IDE (https://www.eclipse.org/downloads/)
Guide on installation from the Eclipse website (https://www.eclipse.org/downloads/packages/installer)

- Maven (https://maven.apache.org/download.cgi)
Guide on installation for Maven provided on their website (https://maven.apache.org/install.html)
```

### Installing

Cloning the repository from GitHub:
To clone a repository, run the following command in a Git Bash or Terminal, ensuring you are in a suitable location for the folder to be cloned to.

```
git clone https://github.com/adilakbarali/ims-project.git
```

Importing the project to Eclipse:


```
In Eclipse, Navigate to File > Import
From here we need to import an Existing Maven Project
and Select Folder on the root folder of the cloned repository
After importing the project, right click the project in the Package Explorer
Maven > Update Project
This will force the dependencies to download/update.
```

Configuring MySQL Database:

```
Navigate to the ims_full_schema.sql(src/main/resources/ims_full_schema.sql) and ims_test_data.sql(src/main/resources/ims_test_data.sql).
Once these are open in MySQL, first run ims_full_schema.sql, followed by ims_test_data.sql. This will create the tables 
and fill in some test data to be used with the application*.

* You may need to modify the db.properties file (src/main/resources/db.properties) 
to match the IP Address, username and password with your MySQL configuration.
This will also need to be done to the db.properties file (src/test/resources/db.properties)
to run any of the JUnit tests.
```

Testing that the environment is correctly set up:

```
Run the application by right clicking Runner.java > Run As > 1 Java Application
Input the following commands in the application: ORDER > READ
You should expect the results below:
id:1 customer id:1 item name:Keyboard value:£29.99 quantity:2
id:1 customer id:1 item name:Monitor value:£129.99 quantity:1
id:1 customer id:1 item name:Mouse value:£15.99 quantity:1
id:2 customer id:2 item name:8GB Flash Drive value:£9.99 quantity:3
Please reference the above steps if any errors occur
```

## Running the tests

The project contains a few test packages under src/test/java, and they are broken up into Domains, DAOs, and Controllers.
To run these test packages, right click src/test/java > Run As > JUnit Test
To run individual tests, expand the packages and pick a particular test class to run, Run As > JUnit Test

### Unit Tests 

The purpose of unit testing is to ensure each method within a particular class/application works as intended.
We use Mockito to "mock" objects within the application to allow us to perform these tests without user input at runtime.
The primary target classes for the unit tests were the Controller classes.

```
To run any of the Unit tests, navigate to src/test/java
Right click the package labelled 'com.qa.ims.controllers' > Run As > JUnit Test
```

### Integration Tests 

Integration Tests are used to test how the objects within the application interact with each other.
These tests are vital to ensure the complete functionality of the application. Within the IMS, the 
integration tests are carried out on the DAO objects.

```
To run any of the Integration tests, navigate to src/test/java
Right click the package labelled 'com.qa.ims.dao' > Run As > JUnit Test
```

## Deployment

To deploy to a live system, ensure the initial setup steps for 'Configuring the MySQL Database' have
been carried out. If you are generating your own data, either modify ims_test_data.sql(src/main/resources/ims_test_data.sql)
before running the application, or generate the data within the application using the inbuilt methods.*

In a new terminal in the root project folder, execute the following command: 'mvn clean package'
This should build the package into a .jar file. From here, we can execute the .jar file in the terminal using
the command: 'java -jar target/my_jar.jar'

*This may be slower/more time consuming than creating entries using MySQL.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Adil Akbarali** - *Development & Testing of IMS Application* - [adilakbarali](https://github.com/adilakbarali)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Massive thank you to Morgan Walsh and Aswene Sivaraj for the guidance and assistance provided throughout this project
* Also a massive thank you to the rest of the QA Trainers for in-depth and effective training
