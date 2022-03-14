package uz.nb.simple_trello.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.auth.AuthUserCreateDto;
import uz.nb.simple_trello.dto.auth.AuthUserDto;
import uz.nb.simple_trello.dto.auth.AuthUserUpdateDto;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto>,
        uz.nb.simple_trello.mapper.base.Mapper {

    @Override
    AuthUserDto toDto(AuthUser authUser);

    @Override
    List<AuthUserDto> toDto(List<AuthUser> e);

    @Override
    AuthUser fromCreateDto(AuthUserCreateDto dto);

    @Override
    AuthUser fromUpdateDto(AuthUserUpdateDto authUserUpdateDto);
}
