package com.teradata.kafka.consumer;

import com.teradata.kafka.connector.Connector;

public interface GenericConsumer {
	
	public void consume(Connector connector) throws Exception;

}
