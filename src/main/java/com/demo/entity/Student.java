package com.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name ="students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String email;
	String fullname;
	Double marks;
	Boolean gender;
	String country;
}
