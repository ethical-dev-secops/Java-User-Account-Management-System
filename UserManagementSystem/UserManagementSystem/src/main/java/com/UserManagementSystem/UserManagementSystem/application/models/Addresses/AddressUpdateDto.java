package com.UserManagementSystem.UserManagementSystem.application.models.Addresses;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.Address;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressUpdateDto {
    private UUID Id;
    private String Unitnumber;
    private String Street;
    private String Suburb;
    private String City;

    public static AddressUpdateDto mapFromAddress(Address address, ModelMapper mapper) {
        return mapper.map(address, AddressUpdateDto.class);
    }

    public static List<AddressUpdateDto> mapFromAddresses(Collection<Address> addresses, ModelMapper mapper) {
        return addresses
            .stream()
            .map(address -> AddressUpdateDto.mapFromAddress(address, mapper))
            .collect(Collectors.toList());
    }
}