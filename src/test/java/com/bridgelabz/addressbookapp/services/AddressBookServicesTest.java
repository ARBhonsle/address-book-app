package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.constants.Message;
import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AddressBookServicesTest {
    @InjectMocks
    AddressBookServices addressBookServices;

    @Mock
    AddressBookRepository addressBookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private List<AddressBook> addressBookList;

    @BeforeEach
    void setUp() {
        addressBookList = new ArrayList<>();
    }

    @Test
    public void findAddressBookPayrollData_shouldReturnListInResponseDto() {
        AddressBook addressBook = new AddressBook();
        addressBook.setFname("Terissa");
        AddressBook addressBook1 = new AddressBook();
        addressBook1.setFname("Simpson");
        addressBookList.add(addressBook);
        addressBookList.add(addressBook1);
        Mockito.when(addressBookRepository.findAll()).thenReturn(addressBookList);
        ResponseDto responseDto = addressBookServices.findAllAddressBook();
        Assertions.assertEquals(addressBookList, responseDto.getData());
    }

    @Test
    public void findAddressBookById_shouldReturnAddressBookInResponseDto() throws AddressBookException {
        AddressBook addressBook = new AddressBook();
        addressBook.setFname("Terissa");
        addressBookList.add(addressBook);
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));
        ResponseDto responseDto = addressBookServices.findAddressBookById(1);
        Assertions.assertNotNull(responseDto.getData());
        Mockito.verify(addressBookRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void findAddressBookById_shouldThrowException() {
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(AddressBookException.class, () -> addressBookServices.findAddressBookById(1)));
        Mockito.verify(addressBookRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void saveAddressBook_shouldAddAddressBookAndReturnResponseDto() {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFname("Terissa");
        AddressBook addressBook = new AddressBook();
        addressBook.setFname(addressBookDto.getFname());
        Mockito.when(addressBookRepository.save(addressBook)).thenReturn(addressBook);
        ResponseDto responseDto = addressBookServices.saveAddressBook(addressBookDto);
        Assertions.assertNotNull(responseDto.getData());
        Assertions.assertEquals(addressBook, responseDto.getData());
        Mockito.verify(addressBookRepository, Mockito.times(1)).save(addressBook);
    }

    @Test
    public void updateAddressBook_shouldReturnUpdatedAddressBookInResponseDto() throws AddressBookException {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFname("Terissa");
        AddressBook addressBook = new AddressBook();
        addressBook.setFname("Tabby");
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));
        addressBook.setFname(addressBookDto.getFname());
        Mockito.when(addressBookRepository.save(addressBook)).thenReturn(addressBook);
        ResponseDto responseDto = addressBookServices.updateAddressBook(1, addressBookDto);
        Assertions.assertNotNull(responseDto.getData());
        Assertions.assertEquals(addressBook, responseDto.getData());
        Mockito.verify(addressBookRepository, Mockito.times(1)).save(addressBook);
    }

    @Test
    public void updateAddressBook_shouldThrowException() {
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(AddressBookException.class, () -> addressBookServices.findAddressBookById(1)));
        Mockito.verify(addressBookRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void deleteAddressBook_shouldReturnStringMessageInResponseDto() throws AddressBookException {
        AddressBook addressBook = new AddressBook();
        addressBook.setFname("Terissa");
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));
        Assertions.assertNotNull(addressBook);
        ResponseDto responseDto = addressBookServices.deleteAddressBook(1);
        Assertions.assertEquals(Message.DELETE_SUCCESS_RESPONSE.getMessage(),responseDto.getData());
    }

    @Test
    public void deleteAddressBook_shouldThrowException(){
        Mockito.when(addressBookRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertNotNull(Assertions.assertThrows(AddressBookException.class, () -> addressBookServices.findAddressBookById(1)));
        Mockito.verify(addressBookRepository, Mockito.times(1)).findById(1);
    }

}
