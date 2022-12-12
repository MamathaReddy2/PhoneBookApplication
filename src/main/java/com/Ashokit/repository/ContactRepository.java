package com.Ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ashokit.binding.Contact;
// Interface is extending the properties from JPS repository. It will provide the methods 
//to perform the CRUD operations 
//Data jpa has predifined crud operations
//Contact as Entity class and integer as data type
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
