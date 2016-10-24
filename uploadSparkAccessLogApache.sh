#$1 will hold the location of the log file in your machine that needs to be updated to the system
hadoop fs -mkdir /user/cloudera/sparkInput
hadoop fs -put $1 /user/cloudera/sparkInput/