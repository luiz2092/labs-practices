package com.bug.apibug.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bug")
public class BugEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_bug")
	private int idBug;

	@Column(name = "email")
	private String email;

	@Column(name = "owner")
	private String owner;

	@Column(name = "priority")
	private String priority;

	@Column(name = "status")
	private String status;

	@Column(name = "ownerProject")
	private String ownerProject;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "completionDate")
	private Date completionDate;

	@Column(name = "description")
	private String description;

}
