package com.UserManagementSystem.UserManagementSystem.application.models.UserGroups;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.UserManagementSystem.UserManagementSystem.domain.models.UserGroup;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGroupUpdateDto {
    private UUID Id;
    private String GroupName;

    public static UserGroupUpdateDto mapFromUserGroup(UserGroup userGroup, ModelMapper mapper) {
        return mapper.map(userGroup, UserGroupUpdateDto.class);
    }

    public static List<UserGroupUpdateDto> mapFromUserGroups(Collection<UserGroup> userGroups, ModelMapper mapper) {
        return userGroups
            .stream()
            .map(userGroup -> UserGroupUpdateDto.mapFromUserGroup(userGroup, mapper))
            .collect(Collectors.toList());
    }
}