package com.example.awslambda.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreRepositoryTest {

	@Autowired
	private StoreRepository storeRepository;
	
	
	
	
	@Test
	void testSave() {
		Store s= new Store();
		s=storeRepository.save(s);
		assertNotNull(s.getId());
	}

	
}
