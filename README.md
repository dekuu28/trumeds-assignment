# trumeds-assignment
assignment task
- remove adjacent similar characters one at
  a time and maintain the count taken to get the final result which should not have any pairs in it, save
  the processed data i.e final output, count i.e number of steps to achieve final output
- The application should be able to connect to MySQL database and fetch data from
  truemeds.input_details table, use the data and process it to remove adjacent similar characters one at
  a time and maintain the count taken to get the final result which should not have any pairs in it, save
  the processed data i.e final output, count i.e number of steps to achieve final output and your name
  with the current timestamp in a new table firstname_lastname_java_output.
  
This Application has two REST entpoints

1.  POST : /assignment/{input}
    output : count
    
2. Get : /assignment/processInput
   Its a trigger which will fetch input from input table and store output in output table with timestamp.
   
   
Note: Some JUnit test are written in test package ( using Junit5 )