package com.UserManagementSystem.UserManagementSystem.application.models.Addresses;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressCreateDto {
    private String Unitnumber;
    private String Street;
    private String Suburb;
    private String City;

    public static AddressCreateDto mapFromAddress(Address address, ModelMapper mapper) {
        return mapper.map(address, AddressCreateDto.class);
    }

    public static List<AddressCreateDto> mapFromAddresses(Collection<Address> addresses, ModelMapper mapper) {
        return addresses
            .stream()
            .map(address -> AddressCreateDto.mapFromAddress(address, mapper))
            .collect(Collectors.toList());
    }
}