package com.UserManagementSystem.UserManagementSystem.application.services;

import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressUpdateDto;
import java.util.List;
import java.util.UUID;


public interface AddressService {
    UUID CreateAddress(AddressCreateDto dto);

    AddressDto FindAddressById(UUID id);

    List<AddressDto> FindAddresses();

    void UpdateAddress(UUID id, AddressUpdateDto dto);

    void DeleteAddress(UUID id);

}