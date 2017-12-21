package org.efremov.idgenerator.service;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdGeneratorServiceTestImpl {
	private IdGeneratorServiceImpl idGeneratorService;
	
	@Before
	public void setUp() {
		idGeneratorService = new IdGeneratorServiceImpl();
	}
	
	@Test
	public void generateNewId() {
		// when 
		String id = idGeneratorService.generateId();
		
		//then
		
		assertThat(id).isInstanceOf(String.class);
	}
}
