# removing local output directory
rm -r ~/Desktop/output

# comment the following line in production mode. Doing this to reduce the number  of time the manual delete should take place
hadoop fs -rm -r /user/cloudera/output

# $1 should hold the address for your jar file that needs to be executed
# output will be created in output directory of the /cloudera location
spark-submit --master local --class spark.ApacheLog $1 hdfs://quickstart.cloudera:8020/user/cloudera/sparkInput

#get the result
hadoop fs -get /user/cloudera/output ~/Desktop