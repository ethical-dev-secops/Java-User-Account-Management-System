package com.UserManagementSystem.UserManagementSystem.application.services;

import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupCreateDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupDto;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupUpdateDto;
import java.util.List;
import java.util.UUID;


public interface UserGroupService {
    UUID CreateUserGroup(UserGroupCreateDto dto);

    UserGroupDto FindUserGroupById(UUID id);

    List<UserGroupDto> FindUserGroups();

    void UpdateUserGroup(UUID id, UserGroupUpdateDto dto);

    void DeleteUserGroup(UUID id);

}