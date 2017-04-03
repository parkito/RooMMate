package com.portal.controllers.convertors.implementation;

import com.portal.controllers.convertors.api.DTOtoEntityConverter;
import com.portal.dto.GroupDTO;
import com.portal.entities.Group;
import com.portal.exceptions.EntityToDTOConvertException;
import com.portal.exceptions.GroupNotFoundException;
import com.portal.services.api.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
public class GroupDTOtoGroupEntity implements DTOtoEntityConverter<GroupDTO, Group> {
    @Autowired
    GroupService groupService;

    @Override
    public Group convert(GroupDTO dto) {
        Group group = null;
        try {
            group = groupService.getGroupByTitle(dto.getTitle());
        } catch (GroupNotFoundException ex) {
            throw new EntityToDTOConvertException("Group " + dto.getTitle() + " wasn't found", ex);
        }
        return group;
    }

    @Override
    public List<Group> convertList(List<GroupDTO> dtoList) {
        List<Group> result = new ArrayList<>();
        for (GroupDTO groupEntity : dtoList) {
            result.add(convert(groupEntity));
        }
        return result;
    }
}
