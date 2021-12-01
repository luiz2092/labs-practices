package com.bug.apibug.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugModel {

	private String email;
	@NotNull
	@NotBlank
	private String owner;
	private String priority;
	private String status;
	private String ownerProject;

	private Date createdDate;
	private Date completionDate;
	private String description;
}
