package com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupCreateDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;

public class UserGroupToUserGroupCreateDtoMapping extends PropertyMap<UserGroup, UserGroupCreateDto> {
    protected void configure() {
    }
}