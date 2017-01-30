package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.EntityToDTOConverter;
import com.portal.dto.GroupDTO;
import com.portal.entities.Group;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
public class GroupEntityToGroupDTO implements EntityToDTOConverter<Group, GroupDTO> {
    @Override
    public GroupDTO convert(Group entity) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setTitle(entity.getTitle());
        groupDTO.setUsers(entity.getUsers());
        return groupDTO;
    }
}
