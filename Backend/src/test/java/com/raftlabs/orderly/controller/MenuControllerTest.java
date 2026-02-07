package com.raftlabs.orderly.controller;

import com.raftlabs.orderly.model.menu.request.MenuCreateRequestDTO;
import com.raftlabs.orderly.model.menu.response.MenuResponseDTO;
import com.raftlabs.orderly.service.MenuService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @InjectMocks
    private MenuController menuController;

    @Mock
    private MenuService menuService;

    @Test
    void createMenu_ShouldCreateMenuSuccessfully() {

        MenuCreateRequestDTO requestDTO = new MenuCreateRequestDTO();
        requestDTO.setName("Cheese Pizza");
        requestDTO.setCategory("pizza");
        requestDTO.setDescription("Classic pizza");
        requestDTO.setPrice(BigDecimal.valueOf(299));

        MenuResponseDTO responseDTO = new MenuResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setName("Cheese Pizza");
        responseDTO.setPrice(BigDecimal.valueOf(299));

        Mockito.when(menuService.createMenu(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<MenuResponseDTO> response =
                menuController.createMenu(requestDTO);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("Cheese Pizza", response.getBody().getName());

        Mockito.verify(menuService, Mockito.times(1))
                .createMenu(requestDTO);
    }

    @Test
    void getAllMenus_ShouldReturnList() {

        MenuResponseDTO dto = new MenuResponseDTO();
        dto.setId(1L);
        dto.setName("Burger");

        Mockito.when(menuService.getAllMenus())
                .thenReturn(List.of(dto));

        ResponseEntity<List<MenuResponseDTO>> response =
                menuController.getAllMenus();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().size());

        Mockito.verify(menuService, Mockito.times(1))
                .getAllMenus();
    }



}

