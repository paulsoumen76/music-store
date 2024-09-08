# music-store

This app is a spring boot demo project
topic covered (authentication and partial authorization, interceptor, cucumber, junit, mockito)
#About
appName: music-album
user can register then login using jwt and upload music album.
for monitoring api invokes we have log.txt in root folder.
user need to validate certaion params 
buinesslogic test case scenario covered using junit and mockito 
BDD is acheived using cucumber
#update
in future will add more functionality

Tool Requirements:
------------------

java 17
intelij
mysql

kafka commad:
-------------
#zoo service
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#kafka server
.\bin\windows\kafka-server-start.bat .\config\server.properties

#topic creation
.\bin\windows\kafka-topics.bat --create --topic your-topic-name --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

#topic list
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
#delete a topic
.\kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic your-topic-name from bin/windows directory