# teradata-kafka-connector
## Use-case
* Post message (json) on Kafka broker. The message is seriaized with Avro
* Consume that message from AvroConsumer.  
* The data is inserted in Vantage using TDJDBC driver to a existing table
* The schema, table prereated at Vantage 

## Pre-requisites
* Confluent 5.1 version
* Maven 3.3.9 (or latest)
* JDK 1.8
* Vantage 16.20.00.12 (Environment provided by DemoService team)
* TD JDBC driver version 16.20.00.10
## Setup steps
* Download Confluent  https://www.confluent.io/download/
* Untar to a location
* Export confluent home in .bashrc
	* E.g. export CONFLUENT_HOME=/home/ravi/work/sw/confluent-5.1.0/
* Start the confluent
	* $ confluent start
	* start logs:
		* Starting zookeeper
		* zookeeper is [UP]
		* Starting kafka
		* kafka is [UP]
		* Starting schema-registry
		* schema-registry is [UP]
		* Starting kafka-rest
		* kafka-rest is [UP]
		* Starting connect
		* connect is [UP]
		* Starting ksql-server
		* ksql-server is [UP]
		* Starting control-center
		* control-center is [UP]
	* **Note:** The kafka ecosystem is running on localhost

* Code base set up
	* git clone https://github.td.teradata.com/teradata-managed-cloud/teradata-kafka-connector
	* cd to kafka-connector
	* Execute maven command to install TD JDBC driver in local maven repo
	* $ mvn install:install-file -Dfile=lib/TeraJDBC__indep_indep.16.20.00.10/terajdbc4.jar -DgroupId=com.teradata -DartifactId=terajdbc -Dversion=4.0 -Dpackaging=jar
	*  $ mvn install:install-file -Dfile=lib/TeraJDBC__indep_indep.16.20.00.10/tdgssconfig.jar -DgroupId=com.teradata -DartifactId=tdgssconfig -Dversion=4.0 -Dpackaging=jar
	* $ mvn clean install
	* On success, should create a fat/uber jar in target
	* Import the project in IDE and set it up (may need to run $ mvn eclipse:eclipse)
	* Run the App from IDE or use java -jar target/kafka-connector-1.0-SNAPSHOT.jar

* Create a topic on Kafka
	* kafka-topics --zookeeper localhost:2181 --create --replication-factor 1 --partitions 3 --topic testTopic

* Start the kafka Avro producer (can be replaced with custom producer)
	* $ kafka-avro-console-producer --broker-list localhost:9092 --topic testTopic --property value.schema='{"type":"record","name":"myrecord","fields":[{"name":"f1","type":"string"}]}'
	* **Note** the schema can be any generic schema
	* This open the producer to produce streaming messages on the created topic
	* Sample input: 
		* {"f1": "value1"}
		* {"f1": "value2"}
	* Observation: The consumer deserializes the data and inserts into TD DB 
	
* Load test, Run test class TestKafkaAvroConsumer	
## Important links
* TD JDBC driver download: http://downloads.teradata.com/download/connectivity/jdbc-driver
* Confluent download: https://www.confluent.io/download/

## AWS execution steps
* Step1: ssh to kafka zookeeper EC2 and start the server
	* cd /home/ec2-user/kafka_2.11-2.1.0
	* nohup bin/zookeeper-server-start.sh config/zookeeper.properties &
	* tail -f logs/server.log
* Step2: ssh to kafka cluster EC2 and start the server
	* cd /home/ec2-user/kafka_2.11-2.1.0
	* nohup bin/kafka-server-start.sh config/server.properties &
	* tail -f logs/server.log
* step3: ssh to producer (streamsets) EC2 and run following
	* start confluent 
		* cd ravi/confluent
		* bin/conflent start (we need schema registry)
	* Start the connector
		* cd /home/ec2-user/ravi/connector
		* java -jar kafka-connector-1.0-SNAPSHOT.jar
		* **Note:** Restarting consumer will clean the table
	* Start the producer
		* cd /home/ec2-user/ravi/producer
		* java -jar kafka-producer-1.0-SNAPSHOT.jar /home/ec2-user/ravi/producer/schema1.json 1000
		* java -jar kafka-producer-1.0-SNAPSHOT.jar /home/ec2-user/ravi/producer/schema_employee.json 1000
		* **Note:** 
			* schema1.json is the custom json file
			```
			{	"namespace": "com.teradata.kafka.sample",
				"type": "record",
				"name":"myrecord",
				"fields":[{"name":"f1","type":"string"}]
			}
			```
			
			* schema_employee.json is the custom employee record json file
			```
			{ "namespace": "com.teradata.kafka.employee",
			  "type": "record",
			  "name": "Employee",
			  "doc" : "Represents an Employee at a company",
			  "fields": [
			    {"name": "firstName", "type": "string", "doc": "The persons given name"},
			    {"name": "nickName", "type": ["null", "string"], "default" : null},
			    {"name": "lastName", "type": "string"},
			    {"name": "age",  "type": "int", "default": -1},
			    {"name": "emails", "default":[], "type": "string"},
			    {"name":"status", "default" :"SALARY", "type": "string"}
			  ]
			}
			```
			
			* 1000 is the number of messages to post

## Useful command	
* scp commands
	* sudo scp -i <pathToPem>/xx.pem target/kafka-producer-1.0-SNAPSHOT.jar  ec2-user@52.13.184.39:/home/ec2-user/ravi/producer/.
	* sudo scp -i <pathToPem>/xx.pem <schemaFilePath>/schema1.json  ec2-user@52.13.184.39:/home/ec2-user/ravi/producer/.
	* sudo scp -i <pathToPem>/xx.pem target/kafka-connector-1.0-SNAPSHOT.jar   ec2-user@52.13.184.39:/home/ec2-user/ravi/connector/.

* Download confluent
	* curl -O http://packages.confluent.io/archive/5.1/confluent-5.1.0-2.11.tar.gz

* Maven project template
	* mvn archetype:generate -DgroupId=com.teradata.kafka -DartifactId=kafka-producer -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

* Kafka topic creation
	* kafka-topics --zookeeper localhost:2181 --create --replication-factor 1 --partitions 3 --topic testTopic
	
