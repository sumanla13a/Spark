# Spark
  - Author Suman Lama

  - Installation
    1. download cloudera
    2. download vBox or VM-ware
    3. Run it
    
  - Development
    1. create a new Maven Project
    2. Add spark library dependency in pom.xml file
    3. wordCountJava7
        - Define configuration to setup spark with our app.
        - Take input.
        - Use flat map to make an arrayList of all the methods (GET, POST,...) and the response message.
        - Use mapToPair to map the arrayList to list of tuple with values 1 for all entries.
        - Sum all the values of tuple with common key.
        - Save the output in a file.
        

  - How to Run
    1. There are two shell scripts with this project. Change permission of both files to 700 or your choice with execution right.
    2. Run uploadSparkAccessLogApache.sh with <code>./uploadSparkAccessLogApache.sh {location of the log file}</code>
    3. Run spark.sh with <code>./spark.sh {location of jar file}</code>
