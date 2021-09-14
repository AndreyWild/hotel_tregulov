package com.senla.hotel.service;

import com.senla.hotel.api.dao.IMaintenanceDao;
import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.dto.MaintenanceDto;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Maintenance;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MaintenanceService implements IMaintenanceService {

    private IMaintenanceDao maintenanceDao;
    private final ModelMapper modelMapper;

    @Override
    public Maintenance save(Maintenance entity) {
        return maintenanceDao.save(entity);
    }

    @Override
    public MaintenanceDto getById(Long id) {
        Maintenance maintenance = maintenanceDao.getById(id);

        if(maintenance == null){
            throw  new NoSuchEntityException("There is no Maintenance with ID = " + id + " in Database");
        }

        return modelMapper.map(maintenance, MaintenanceDto.class);
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceDao.getAll();
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceDao.findAll();
    }

    @Override
    public void delete(Maintenance entity) {
        maintenanceDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        Maintenance maintenance = maintenanceDao.getById(id);
        if (maintenance == null) {
            throw new NoSuchEntityException("There is no maintenance with ID = "
                    + id + " in Database");
        }
        maintenanceDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        maintenanceDao.deleteAll();
    }

    @Override
    public void update(Maintenance entity) {
        maintenanceDao.update(entity);
    }
}
