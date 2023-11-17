package com.UserManagementSystem.UserManagementSystem.application.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupUpdateDto;
import com.UserManagementSystem.UserManagementSystem.application.services.UserGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-group")
@Tag(name = "UserGroupService")
@AllArgsConstructor
public class UserGroupController {
    private final UserGroupService userGroupService;

    @PostMapping
    @Operation(summary = "CreateUserGroup")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public ResponseEntity<UUID> CreateUserGroup(@Valid @Parameter(required = true) @RequestBody UserGroupCreateDto dto) {
        final UUID result = userGroupService.CreateUserGroup(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "FindUserGroupById")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified UserGroupDto."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred."),
        @ApiResponse(responseCode = "404", description = "Can\'t find an UserGroupDto with the parameters provided.") })
    public ResponseEntity<UserGroupDto> FindUserGroupById(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        final UserGroupDto result = userGroupService.FindUserGroupById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "FindUserGroups")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the specified List<UserGroupDto>.") })
    public ResponseEntity<List<UserGroupDto>> FindUserGroups() {
        final List<UserGroupDto> result = userGroupService.FindUserGroups();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}")
    @Operation(summary = "UpdateUserGroup")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully updated."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void UpdateUserGroup(@Parameter(required = true) @PathVariable(value = "id") UUID id, @Valid @Parameter(required = true) @RequestBody UserGroupUpdateDto dto) {
        userGroupService.UpdateUserGroup(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "DeleteUserGroup")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted."),
        @ApiResponse(responseCode = "400", description = "One or more validation errors have occurred.") })
    public void DeleteUserGroup(@Parameter(required = true) @PathVariable(value = "id") UUID id) {
        userGroupService.DeleteUserGroup(id);
    }
}
