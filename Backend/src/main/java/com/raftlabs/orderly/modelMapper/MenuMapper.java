package com.raftlabs.orderly.modelMapper;

import com.raftlabs.orderly.entity.MenuItem;
import com.raftlabs.orderly.model.menu.request.MenuCreateRequestDTO;
import com.raftlabs.orderly.model.menu.response.MenuResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper {


    MenuItem toEntity(MenuCreateRequestDTO dto);


    MenuResponseDTO toResponseDto(MenuItem menuItem);
}
