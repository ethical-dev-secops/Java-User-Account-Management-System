package com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupUpdateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;

public class UserGroupToUserGroupUpdateDtoMapping extends PropertyMap<UserGroup, UserGroupUpdateDto> {
    protected void configure() {
    }
}