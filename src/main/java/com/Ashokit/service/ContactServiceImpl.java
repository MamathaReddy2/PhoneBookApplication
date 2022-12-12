package com.Ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashokit.binding.Contact;
import com.Ashokit.repository.ContactRepository;

//Whenever we implement a interface in service impl class need to import all unimplemented abstract methods of the interface
@Service
//Service class should call the repository. Repository object should inject into service class.
public class ContactServiceImpl implements ContactService {
	// Dependency injection
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		// Implement service layer methods
		// repo.save is the predefined method which will take the contact object as
		// input and saves/insert the record into the DB. Creates the primary key once
		// it is saved
		Contact save = repo.save(contact); // insertion

		if (contact.getContactId() != null) {
			return "Contact Saved";
		} else {
			return "Contact Failed To Save";
		}

	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// optional is to avoid null pointer exception
		// findById is to retrieve the record based on the primary key id
		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		// For insertion and updation we use save method. Whenever user pass the contact
		// object, if the object has primary key or will update the record. If the
		// object doesn't have the primary key it will create the record
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact); // update operation
			return "Update Success";
		} else {
			return "No Record Found";

		}

	}

	@Override
	public String deleteContactById(Integer contactId) {
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);

			return "Record Deleted";
		} else {
			return "No Record Found";
		}

	}
}