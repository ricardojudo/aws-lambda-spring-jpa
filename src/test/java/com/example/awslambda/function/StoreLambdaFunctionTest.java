package com.example.awslambda.function;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.example.awslambda.domain.Store;
import com.example.awslambda.domain.StoreRepository;

@SpringBootTest
class StoreLambdaFunctionTest {

	@Autowired
	private StoreLambdaFunction function;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Test
	void test() {
		Message<Store> message = MessageBuilder.withPayload(new Store()).build();
		function.apply(message);
		assertThat(storeRepository.count()).isGreaterThan(0L);
	}

}
