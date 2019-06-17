package com.example.awslambda.function;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.awslambda.domain.Store;
import com.example.awslambda.domain.StoreRepository;

@Component
public class StoreLambdaFunction implements Function<Message<Store>, Message<Store>>{

	@Autowired
	private StoreRepository storeReposiroty;
	
	private static Logger logger = LoggerFactory.getLogger(StoreLambdaFunction.class);
	
	@Override
	public Message<Store> apply(Message<Store> message) {
		Store store = message.getPayload();
		store = storeReposiroty.save(store);
		logger.info("Saved? : {} : {}", store.getId(), store);
		return MessageBuilder.withPayload(store).build();
	}

	

}
