package com.UserManagementSystem.UserManagementSystem.application.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressDto;
import com.UserManagementSystem.UserManagementSystem.application.models.Addresses.AddressUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
@Tag(name = "AddressService")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    @Operation(summary = "CreateAddress")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public ResponseEntity<UUID> CreateAddress(@Valid @Parameter(required = true) @RequestBody AddressCreateDto dto) {
        final UUID result = addressService.CreateAddress(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "FindAddressById")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified AddressDto."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred."),
        @ApiResponse(responseCode = "404", description = "Can\'t find an AddressDto with the parameters provided.") })
    public ResponseEntity<AddressDto> FindAddressById(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        final AddressDto result = addressService.FindAddressById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "FindAddresses")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified List<AddressDto>.") })
    public ResponseEntity<List<AddressDto>> FindAddresses() {
        final List<AddressDto> result = addressService.FindAddresses();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}")
    @Operation(summary = "UpdateAddress")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully updated."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void UpdateAddress(@Parameter(required = true) @PathVariable(value = "id") UUID id, @Valid @Parameter(required = true) @RequestBody AddressUpdateDto dto) {
        addressService.UpdateAddress(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "DeleteAddress")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void DeleteAddress(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        addressService.DeleteAddress(id);
    }
}
