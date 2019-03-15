package com.teradata.cloudmigration.nparcProxy.activemq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class JMSConfig {
	
	@Value("spring.activemq.broker-url")
    private String activeMqUrl;
	
	@Bean
	@Qualifier("sourceQueue")
	public Queue sourceQueue() {
		return new ActiveMQQueue("source.queue");
	}

	@Bean
	@Qualifier("targetQueue")
	public Queue targetQueue() {
		return new ActiveMQQueue("target.queue");
	}
	
	@Bean
	@Qualifier("responseQueue")
	public Queue responseQueue() {
		return new ActiveMQQueue("response.queue");
	}

	@Bean
	public Topic responseTopic() {
		return new ActiveMQTopic("response.topic");
	}
	
	
	/*@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory =
	            new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setDestinationResolver(destinationResolver());
	    factory.setConcurrency("3-10");
	    factory.setClientId("brokerClientId");
	    factory.setSubscriptionDurable(true);
	    return factory;
	}*/

	/*// Only required due to defining myFactory in the receiver
	  @Bean
	  public JmsListenerContainerFactory<?> myFactory(
	      ConnectionFactory connectionFactory,
	      DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    configurer.configure(factory, connectionFactory);
	    return factory;
	  }
	  // Serialize message content to json using TextMessage
	  @Bean
	  public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	  }*/


}
