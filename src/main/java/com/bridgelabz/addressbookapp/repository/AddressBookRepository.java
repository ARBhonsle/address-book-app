package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address book Repository store, encapsulates and retrieves data for executing http requests
 *
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
