package com.senla.hotel.service;

import com.senla.hotel.api.dao.IMaintenanceDao;
import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.dto.MaintenanceDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Maintenance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MaintenanceServiceTest {

    private IMaintenanceService maintenanceService;
    @Mock
    private IMaintenanceDao maintenanceDao;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Maintenance maintenance;
    @Mock
    private MaintenanceDto maintenanceDto;

    private static final Long ID = 1L;

    @BeforeEach
    void setUp() {

        maintenanceService = new MaintenanceService(maintenanceDao, modelMapper);
        maintenance.setId(ID);
        maintenance.setName("test");
        maintenance.setPrice(333.00);
        maintenanceDto.setId(ID);
        maintenanceDto.setName("test");
        maintenanceDto.setPrice(333.00);
    }

    @Test
    public void whenSaveMaintenanceShouldReturnMaintenanceDto() {
        when(maintenanceDao.save(ArgumentMatchers.any(Maintenance.class))).thenReturn(maintenance);
        when(modelMapper.map(maintenanceDto, Maintenance.class)).thenReturn(maintenance);
        when(modelMapper.map(maintenance, MaintenanceDto.class)).thenReturn(maintenanceDto);
        MaintenanceDto result = maintenanceService.save(maintenanceDto);
        assertEquals(result, maintenanceDto);
        verify(maintenanceDao).save(maintenance);
    }

    @Test
    void getByIdShouldReturnMaintenanceDto() {
        when(maintenanceDao.getById(anyLong())).thenReturn(maintenance);
        when(modelMapper.map(maintenance, MaintenanceDto.class)).thenReturn(maintenanceDto);
        MaintenanceDto result = maintenanceService.getById(anyLong());
        assertEquals(result, maintenanceDto);
        verify(maintenanceDao).getById(anyLong());
    }

    @Test
    void getByIdShouldReturnNull() {
        when(maintenanceDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            maintenanceService.getById(anyLong());
        });
        verify(maintenanceDao).getById(anyLong());
    }

    @Test
    public void shouldReturnAllMaintenanceFirst() {
        List<Maintenance> maintenances = new ArrayList();
        maintenances.add(maintenance);
        List<MaintenanceDto> maintenanceDtos = new ArrayList<>();
        maintenanceDtos.add(maintenanceDto);
        when(modelMapper.map(maintenance, MaintenanceDto.class)).thenReturn(maintenanceDto);
        when(maintenanceDao.getAll()).thenReturn(maintenances);
        List<MaintenanceDto> expected = maintenanceService.getAll();
        assertEquals(expected, maintenanceDtos);
        verify(maintenanceDao).getAll();
    }

    @Test
    public void shouldReturnExceptInsteadMaintenances() {
        given(maintenanceDao.getAll()).willThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {
            maintenanceService.getAll();
        });
        verify(maintenanceDao).getAll();
    }

    @Test
    public void shouldReturnAllMaintenanceSecond() {
        List<Maintenance> maintenances = new ArrayList();
        maintenances.add(maintenance);
        given(maintenanceDao.findAll()).willReturn(maintenances);
        List<Maintenance> expected = maintenanceDao.findAll();
        assertEquals(expected, maintenances);
        verify(maintenanceDao).findAll();
    }


    @Test
    public void whenGivenGuestShouldDeleteMaintenanceIfFound() {
        maintenanceService.delete(maintenance);
        verify(maintenanceDao).delete(maintenance);
    }

    @Test
    public void whenGivenIdShouldDeleteMaintenanceIfFound() {
        when(maintenanceDao.getById(maintenance.getId())).thenReturn(maintenance);
        maintenanceService.deleteById(maintenance.getId());
        verify(maintenanceDao).deleteById(maintenance.getId());
    }

    @Test
    void shouldThrowExceptionWhenMaintenanceDoesntExist() {
        when(maintenanceDao.getById(anyLong())).thenReturn(null);
        assertThrows(NoSuchEntityException.class, () -> {
            maintenanceService.getById(anyLong());
        });
    }

    @Test
    public void update() {
        when(modelMapper.map(maintenanceDto, Maintenance.class)).thenReturn(maintenance);
        maintenanceService.update(maintenanceDto);
        verify(maintenanceDao).update(maintenance);
    }

}