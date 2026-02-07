package com.raftlabs.orderly.service;

import com.raftlabs.orderly.entity.MenuItem;
import com.raftlabs.orderly.model.menu.request.MenuCreateRequestDTO;
import com.raftlabs.orderly.model.menu.response.MenuResponseDTO;
import com.raftlabs.orderly.modelMapper.MenuMapper;
import com.raftlabs.orderly.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    private final  FileSystemStorageService  fileStorageService;

    public MenuResponseDTO createMenu(
            MenuCreateRequestDTO requestDTO

    ) {

        String imageUrl = fileStorageService.uploadFile(requestDTO.getImage());

        MenuItem menuItem = menuMapper.toEntity(requestDTO);
        menuItem.setImageUrl(imageUrl);

        MenuItem savedMenu = menuRepository.save(menuItem);

        return menuMapper.toResponseDto(savedMenu);
    }


    public List<MenuResponseDTO> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(menuMapper::toResponseDto)
                .toList();
    }






}

