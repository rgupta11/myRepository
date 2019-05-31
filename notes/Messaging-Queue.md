# Two types of message delivery: Persistent and Non-persistent
* Persistent: Messages to always be available to a message consumer after they’ve been delivered to the broker, even if that con-sumer isn’t running when the message was sent.
* Non-Persistent: -Typically used for sending notifications or real-time data.
                -Use nonpersistent messages when performance is critical and guar- anteed delivery of the message isn’t required.

* ActiveMQ can be configured to temporarily cache messages for retrieval by message consumers at a later point in time.
* Messages sent to queues and topics are stored differently
* Durable subscription: Using a durable subscription, when a subscriber discon- nects from the JMS provider, it’s the responsibility of the JMS provider to store mes- sages for the subscriber.
  * Upon reconnecting, the durable subscriber will receive all **unexpired messages** from the JMS provider
* Queue: Only when that message has been consumed and acknowl- edged can it be deleted from the broker’s message store.
* Topic:

## URI
* Basically, every URI has the following string format:
<scheme>:<scheme-specific-part>
* tcp://localhost:61616?trace=true
  * translates to “create a TCP connection to the localhost on port 61616.
* ssl://localhost:61617
* In order to exchange messages, producers and consumers (clients) need to connect to the broker.
*   
  
##  Message Durability vs Message Persistences
* Durability:
  * Message durability can only be achieved with the pub/sub domain.
  * When clients connect to a topic, they can do so using a durable or a nondurable subscription
  * Can be durable and non-durable consumers
* Persistence: 
  * Message persistence is independent of the message domain
  * Specified on the message producer’s setDeliveryMode method using one of the JMSDeliveryMode class’s PERSISTENT or NON-PERSISTENT properties as an argument.
  * 

## Dead letter Q
* When messages expire on the ActiveMQ broker (they exceed their time-to-live, if set) or can’t be redelivered, they’re moved to a dead-letter queue
* Can configure the amount of time the ActiveMQ broker should wait before trying to resend the message, whether that time should increase after every failed attempt (use an exponential back-off and back-off multiplier), and the maximum number of redelivery attempts before the message(s) are moved to a dead-letter queue.
* By default, there’s one dead-letter queue for all messages, called AcitveMQ.DLQ,
* Dead-letter strategy to ignore nonpersistent and expired messages, which can prevent overwhelming the ActiveMQ broker with messages
* When a message is sent to a dead-letter queue, an advisory message is generated for it. You can listen for dead-letter queue advisory messages on the topic ActiveMQ.Advisory.MessageDLQd.*.

## Failover transport
* Supports automatic reconnection as well as the ability to connect to another broker just in case the broker to which a client is currently connected becomes unavailable.
  * Use of composite URIs: static:(tcp://host1:61616,tcp://host2:61616)
  * Use of such white space is not allowed, since the URI specification

## Transport connector
* tcp
* ssl
* stomp
* xmpp

Summary of protocols:
* TCP: Summary of network protocols used for client-broker communication. Default network protocol for most use cases.
* NIO: Consider NIO protocol if you need to provide better scalability for connections from produc- ers and consumers to the broker.
* UDP: Consider UDP protocol when you need to deal with the firewall between clients and the broker.
* SSL: Consider SSL when you want to secure communication between clients and the broker. 
* HTTP(S): Consider HTTP(S) when you need to deal with the firewall between clients and the broker.
* VM: Although not a network protocol per se, consider VM protocol when your broker and clients communicate with a broker that is embedded in the same Java Virtual Machine (JVM).

## Retroactive consumers
* provide a limited method of retroactive consumption of messages with- out requiring message persistence, ActiveMQ has the ability to cache a configurable size or number of messages sent on a topic
* Two parts to it
  * (Consumer side) Your message consumers need to inform the ActiveMQ broker that it’s interested in retroactive messages
    * E.g. session.createTopic("soccer.division1.leeds?consumer.retroactive=true");
  * (Broker side)You need to configure the destination in the broker to say how many mes- sages should be cached for consumption at a later point
* At consumer side, set the retroactive flag for the message consumer as above
* At broker side, can configure a number of recovery policies on a topic-by- topic basis. The default is called the FixedSizedSubscriptionRecoveryPolicy, which holds a number of messages in a topic
  

## Summary of protocols used by consumers

* Static protocol

* Failover protocol
  * Implement automatic reconnection.
  * Clients have been configured to connect to only one specific broker. But what should you do in case you can’t connect to the desired bro- ker or your connection fails at the later stage
  * Two ways to provide a list of suitable brokers:
    * static list of available brokers
      * failover:(uri1,...,uriN)?key=value
      * OR
      * failover:uri1,...,uriN
    * dynamic discovery of the available brokers
      * MULTICAST CONNECTOR
      * When IP multicast is configured, ActiveMQ brokers use the multicast protocol to advertise their services and locate the services of other brokers for the purpose of cre- ating networks of brokers. 
      * Clients, on the other hand, use multicast to locate brokers and establish a connection with them.
      * One disadvantage to using the multicast protocol is that discovery is automatic

## Tips:
* Create durable subscribers
* Handle mesage expiry period
* Use ?trace=true in connection URI to log all commands send over to connector
* Failover transport in activeMQ
* Open port 8162 (outbound) at client to support HTTPS  
* Preventing automatic broker discovery (activemq.xml). One disadvantage to using the multicast protocol is that discovery is automatic
  * Remove from openwire connector
    * two or more ActiveMQ instances will automatically connect to one another and begin con- suming one another’s messages.
    * Remove the discoveryUri portion of the openwire transport connector
    * Change `<transportConnector name="openwire" uri="tcp://localhost:61616" discoveryUri="multicast://default"/>`
    * To `<transportConnector name="openwire" uri="tcp://localhost:61616" />`
  * Remove/Comment from default-nc n/w connector
    * Change `<networkConnector name="default-nc" uri="multicast://default"/>`
    * To `<!-- <networkConnector name="default-nc" uri="multicast://default"/> -->`
* Give the broker a unique name (activeMQ.xml)
  * From `<broker xmlns="http://acti vemq.apache.org/schema/core" brokerName="localhost" dataDirectory="${activemq.base}/data">`
  * To `<broker xmlns="http://activemq.apache.org/schema/core brokerName="broker1234" dataDirectory="${activemq.base}/data">` 
* Create Retroactive consumers (see above)
* Configure a client’s redelivery policy so that attempts are made before moving it to dead letter Q
* Dead-letter strategy to ignore nonpersistent and expired messages, which can prevent overwhelming the ActiveMQ broker with messages




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

