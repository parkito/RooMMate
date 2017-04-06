package convertors.implementation;

import api.GroupService;
import convertors.api.DTOtoEntityConverter;
import dto.GroupDTO;
import entities.Group;
import exceptions.EntityToDTOConvertException;
import exceptions.GroupNotFoundException;
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
