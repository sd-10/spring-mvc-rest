package com.training.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springrest.model.Person;
import com.training.springrest.model.PersonListContainer;
import com.training.springrest.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	@RequestMapping(value="/getPersons", method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<PersonListContainer> getPersons()
	{
		List<Person> persons=service.getListOfPersons();
		PersonListContainer personList=new PersonListContainer();
		personList.setPersonList(persons);
		return new ResponseEntity<PersonListContainer>(personList,HttpStatus.OK);
		
		//return personList;
	}
	
	
	
	@RequestMapping(value="/addPersons",method=RequestMethod.POST)
	public  ResponseEntity<Void> addPersons(@RequestBody Person Person)
	{
		service.addPerson(Person);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/*
	 private List<Person> getListOfPersons()
	{
		List<Person> persons=new ArrayList<Person>();
		persons.add(new Person("James","Smith",21));
		persons.add(new Person("John","Davis",23));
		persons.add(new Person("Vikram","Rathore",24));
		return persons;
	}
	 */
}
