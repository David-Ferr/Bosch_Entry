Bosch Entry Exercise - Spring REST API 

----------------------------------------------------------------------------------

Instructions to open the file: 

1- git clone https://github.com/David-Ferr/Bosch_Entry.git
2- open SpringToolSuite 
3- select File -> Open Projects from File System
4- Choose the Directory named Bosch_Entry inside the main project's folder
5- Execute the main .java application

----------------------------------------------------------------------------------

Available API Calls:

1- getAllEmployees:
   (GET: http://localhost:1111/api/employees)
   Returns the Employees that are currently present in the MySQL Database. 

2- get_person:
   (e.g., GET: http://localhost:1111/api/employees/49)
   Returns the Employee which Unique Identifier is "49.
  
3- edit_person:
   (e.g., PUT: http://localhost:1111/api/employees/49)
   Updates the Employee which Unique Identifier is "49".

   Note: Requires a JSON to be sent with the updated Employee's Info:

{
    "name": "David",
    "personal_number": "934635092",
    "ssn": "123-1444-122",
    "job": "Computer Engineer",
    "nationality": "Portuguese",
    "bday": "8/24/1994"
}


4- add_person:
   (e.g., POST: http://localhost:1111/api/employees)
   Adds a new Employee to MySQL database.

   Note: Requires a JSON to be sent with the Employee's Info:
   
{
    "name": "Marta",
    "personal_number": "914586548",
    "ssn": "123-1444-122",
    "job": "Physiotherapist",
    "nationality": "Portuguese",
    "bday": "11/11/2000"
}

5- deleteEmployee:
   (e.g., DELETE: http://localhost:1111/api/employees/49)
   Deletes the Employee which Unique Identifier is "49".

6- get_minimum_age_difference_in_days:
   (e.g., GET: http://localhost:1111/api/employees/ages/14,15)
   Returns a JSON containing both Employees' Info and their age difference in DAYS.

----------------------------------------------------------------------------------

Available Unit Tests:

1- adding_person_test:
   Guarantees that an Employee is adequately added to the existing MySQL Database.

2- assert_database_loaded:
   Asserts that the provided MOCK_Data is already loaded to the MySQL Database containing the base existing Employees.