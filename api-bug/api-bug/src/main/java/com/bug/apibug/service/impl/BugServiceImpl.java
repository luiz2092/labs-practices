package com.bug.apibug.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bug.apibug.entity.BugEntity;
import com.bug.apibug.model.BugModel;
import com.bug.apibug.repository.BugRepository;
import com.bug.apibug.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	@Autowired
	private BugRepository bugRepository;

	@Autowired
	private JmsTemplate jmsTemplate;
	

	@Override
	public void createBug(BugModel bug) {
		ModelMapper mapper = new ModelMapper();
		BugEntity bugEntity = mapper.map(bug, BugEntity.class);
		bugRepository.save(bugEntity);
		//mailClient.sendEmail();
		queueMail(bug.getEmail());
	}
	
	public void createBugFallBack(BugModel bug){
		System.out.println("FallBack");
	}

	@Override
	public List<BugModel> retrieveAllBugs() {
		ModelMapper mapper = new ModelMapper();
		Type type = new TypeToken<List<BugModel>>() {
		}.getType();

		return mapper.map(bugRepository.findAll(), type);
	}

	@Override
	public BugModel retrieveBug(int idBug) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(bugRepository.findById(idBug).get(), BugModel.class);
	}

	private void queueMail(String email) {
		jmsTemplate.convertAndSend("Send email to: ", email);
	}

}
