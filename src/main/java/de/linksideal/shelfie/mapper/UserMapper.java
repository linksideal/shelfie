package de.linksideal.shelfie.mapper;

import de.linksideal.shelfie.domain.User;
import de.linksideal.shelfie.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);
    UserDto toDto(User user);
}
