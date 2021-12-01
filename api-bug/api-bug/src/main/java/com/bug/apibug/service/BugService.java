package com.bug.apibug.service;

import java.util.List;

import com.bug.apibug.model.BugModel;

public interface BugService {

	void createBug(BugModel bug);
 
	BugModel retrieveBug(int idBug);

	List<BugModel> retrieveAllBugs();

}
