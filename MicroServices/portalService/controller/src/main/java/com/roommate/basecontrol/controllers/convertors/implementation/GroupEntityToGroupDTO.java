package convertors.implementation;


import convertors.api.EntityToDTOConverter;
import dto.GroupDTO;
import entities.Group;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<GroupDTO> convertList(List<Group> entitiesList) {
        List<GroupDTO> result = new ArrayList<>();
        for (Group groupEntity : entitiesList) {
            result.add(convert(groupEntity));
        }
        return result;
    }
}
