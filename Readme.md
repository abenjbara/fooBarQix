# FOO BAR FIX KATA

## Statement:
This project implement a function String compute(String) which implements the following rules.

Step 1:  
If the number is divisible by 3, write “Foo” instead of the number
If the number is divisible by 5, add “Bar”
If the number is divisible by 7, add “Qix”
For each digit 3, 5, 7, add “Foo”, “Bar”, “Qix” in the digits order.

Step 2:  
We have a new business request: we must keep a trace of 0 in numbers, each 0 must be replaced by char “*“.


## Implementation: 
this is a Spring Boot project providing one service which we can use to test the compute function.

end-point path: localhost:8080/compute/{input}

## Run the project: 
mvn spring-boot:run
## Run the test and generate the JAR:
mvn clean package
