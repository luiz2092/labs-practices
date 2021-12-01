package com.bug.apibug;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bug.apibug.entity.BugEntity;
import com.bug.apibug.model.BugModel;
import com.bug.apibug.repository.BugRepository;
import com.bug.apibug.service.impl.BugServiceImpl;

@SpringBootTest
public class BugServiceTest {

	@InjectMocks
	private BugServiceImpl bugService;

	@Mock
	private BugRepository bugRepository;

	@BeforeAll
	public static void init() {
		System.out.println("BeforeAll init() method called");
	}

	@BeforeEach
	public void initEach() {
		System.out.println("Before Each initEach() method called");
	}

	@AfterEach
	public void cleanUpEach() {
		System.out.println("After Each cleanUpEach() method called");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("After All cleanUp() method called");
	}

	@Test
	public void testOne() {
		Mockito.when(bugRepository.save(Mockito.any())).thenReturn(new BugEntity());
		bugService.createBug(new BugModel());
	}
}
