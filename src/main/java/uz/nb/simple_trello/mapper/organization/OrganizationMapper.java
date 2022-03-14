package uz.nb.simple_trello.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.organization.OrganizationCreateDto;
import uz.nb.simple_trello.dto.organization.OrganizationDto;
import uz.nb.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.mapper.base.BaseMapper;


@Mapper(componentModel = "spring")
@Component(value = "organizationMapper")
public interface OrganizationMapper extends BaseMapper<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto> , uz.nb.simple_trello.mapper.base.Mapper {

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto);
}

