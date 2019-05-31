Two types of message delivery: *persistent* and *non-persistent*
Persistent: Messages to always be available to a message consumer after they’ve been delivered to the broker, even if that con- sumer isn’t running when the message was sent.
Non-Persistent: -Typically used for sending notifications or real-time data.
                -Use nonpersistent messages when performance is critical and guar- anteed delivery of the message isn’t required.

-ActiveMQ can be configured to temporarily cache messages for retrieval by message consumers at a later point in time.
-Messages sent to queues and topics are stored differently
-Durable subscription: Using a durable subscription, when a subscriber discon- nects from the JMS provider, it’s the responsibility of the JMS provider to store mes- sages for the subscriber.
-Queue: Only when that message has been consumed and acknowl- edged can it be deleted from the broker’s message store.
-Topic: 

  


-ActiveMQ certificates-
------
https://activemq.apache.org/how-do-i-use-ssl.html
https://serverfault.com/questions/9708/what-is-a-pem-file-and-how-does-it-differ-from-other-openssl-generated-key-file

Using keytool, create a certificate for the broker:
keytool -genkey -alias broker -keyalg RSA -keystore broker.ks

--keytool -importkeystore -srckeystore client.ks -destkeystore client.ks -deststoretype pkcs12--
keytool -importkeystore -srckeystore broker.ks -destkeystore broker.ks -deststoretype pkcs12

Export the broker’s certificate so it can be shared with clients:
keytool -export -alias broker -keystore broker.ks -file broker_cert

Create a certificate/keystore for the client:
keytool -genkey -alias client -keyalg RSA -keystore client.ks

keytool -importkeystore -srckeystore client.ks -destkeystore client.ks -deststoretype pkcs12

Create a truststore for the client, and import the broker’s certificate. This establishes that the client “trusts” the broker:
keytool -import -alias broker -keystore client.ts -file broker_cert



Client certificates
If you want to verify client certificates, you need to take a few extra steps:

Export the client’s certificate so it can be shared with broker:
keytool -export -alias client -keystore client.ks -file client_cert

Create a truststore for the broker, and import the client’s certificate. This establishes that the broker “trusts” the client:
keytool -import -alias client -keystore broker.ts -file client_cert


Pem creation
openssl x509 -inform der -in broker_cert -out amq.pem
openssl x509 -inform der -in client_cert -out amq.pem

-----------------------

