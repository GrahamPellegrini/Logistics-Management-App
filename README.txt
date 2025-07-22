# CPS2004 Object Oriented Programming
# Assignment 2023/24

## Questions answered:
Question 1 (a, b, c)

Question 2 (a, b, c)

Question 3 (a, b, c)

Question 4 (a)


## Directory Structure:

Q1_Cpp/: C++ implementation of part 1.

Q1_Java/: Java implementation of part 1.

Q2/: Java implementation for part 2.

Q3/: Java implementation for part 3.

Q3_Cpp/: C++ implementation for part 3.

Q4/: Java implementation for part 4.


## Prerequisites:
Maven Java

CMake

C++ compiler

### Run the Java projects:

Navigate to the project directory (example cd Q1_Java).

Run mvn clean install to build the project.

Run the CLI.java class (main class)

### Run the C++ projects:

Navigate to the project directory (example cd Q1_Cpp).

Right click on the cmake run it and build all files.

Run the CLI.cpp class (main class)

## Code Explanation:

For question 1 the use of collection classes are in place to hold the list of base 
Objects created as well as the methods needed by the cli to manage those objects.


For question 2 Factory pattern is evidently used in the transport class as creation of transport is managed through the transport facotry and the respective type parameter.
As well as the creation for products as the product factory and the sub class factories use type and subtype parameter to create types of products.
Further more the use of decorator classes as used in shipments hierarchy to ensure that methods such as applying global discount or altering routes
can be executed at any stage in the shipments process.


For question 3 a proto file was created with all the neccary messages. Then the respective save() and load() methods where consturtced to be called 
finally by the CLI save() and load() methods in the system interface. For the serialazion and deseraialiation of the objects to be able to save and load
to the proto files, respective convert to/from files are found at the base classes.
The stock viewer class was a simple further implementation on the already implmented product viewer in the product managment methods.
This lists all the respective informtion about the products in stock and the quantity respective to these products in stock.


For question 4 the required proto file was consturcted with respect to the gRPC required for remote seervice and the generated proto files where achieved.


## Contact:
Graham Pellegrini - graham.pellegrini@um.edu.mt


Project Link: https://gitlab.com/GrahamP/oo-programming-assignment-2023_24.git
