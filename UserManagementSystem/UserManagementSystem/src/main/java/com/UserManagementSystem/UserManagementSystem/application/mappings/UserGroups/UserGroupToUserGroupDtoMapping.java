package com.UserManagementSystem.UserManagementSystem.application.mappings.UserGroups;

import org.modelmapper.PropertyMap;
import com.UserManagementSystem.UserManagementSystem.application.models.UserGroups.UserGroupDto;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;

public class UserGroupToUserGroupDtoMapping extends PropertyMap<UserGroup, UserGroupDto> {
    protected void configure() {
    }
}