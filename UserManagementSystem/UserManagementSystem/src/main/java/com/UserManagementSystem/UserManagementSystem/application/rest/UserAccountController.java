package com.UserManagementSystem.UserManagementSystem.application.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserAccounts.UserAccountUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-account")
@Tag(name = "UserAccount")
@AllArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping
    @Operation(summary = "CreateUserAccount")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public ResponseEntity<UUID> CreateUserAccount(@Valid @Parameter(required = true) @RequestBody UserAccountCreateDto dto) {
        final UUID result = userAccountService.CreateUserAccount(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "FindUserAccountById")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified UserAccountDto."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred."),
        @ApiResponse(responseCode = "404", description = "Can\'t find an UserAccountDto with the parameters provided.") })
    public ResponseEntity<UserAccountDto> FindUserAccountById(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        final UserAccountDto result = userAccountService.FindUserAccountById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "FindUserAccounts")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified List<UserAccountDto>.") })
    public ResponseEntity<List<UserAccountDto>> FindUserAccounts() {
        final List<UserAccountDto> result = userAccountService.FindUserAccounts();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}")
    @Operation(summary = "UpdateUserAccount")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully updated."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void UpdateUserAccount(@Parameter(required = true) @PathVariable(value = "id") UUID id, @Valid @Parameter(required = true) @RequestBody UserAccountUpdateDto dto) {
        userAccountService.UpdateUserAccount(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "DeleteUserAccount")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void DeleteUserAccount(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        userAccountService.DeleteUserAccount(id);
    }
}
