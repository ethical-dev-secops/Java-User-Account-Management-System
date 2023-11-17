package com.UserManagementSystem.UserManagementSystem.application.models.UserGroups;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGroupCreateDto {
    private String GroupName;

    public static UserGroupCreateDto mapFromUserGroup(UserGroup userGroup, ModelMapper mapper) {
        return mapper.map(userGroup, UserGroupCreateDto.class);
    }

    public static List<UserGroupCreateDto> mapFromUserGroups(Collection<UserGroup> userGroups, ModelMapper mapper) {
        return userGroups
            .stream()
            .map(userGroup -> UserGroupCreateDto.mapFromUserGroup(userGroup, mapper))
            .collect(Collectors.toList());
    }
}