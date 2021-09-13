package com.senla.hotel.service;

import com.senla.hotel.api.dao.IMaintenanceDao;
import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.exceptions.NoSuchEntityException;
import com.senla.hotel.model.entities.Maintenance;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    private IMaintenanceDao maintenanceDao;

    @Autowired
    public MaintenanceService(IMaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public Maintenance save(Maintenance entity) {
        return maintenanceDao.save(entity);
    }

    @Override
    public Maintenance getById(Long id) {
        Maintenance maintenance = maintenanceDao.getById(id);

        if(maintenance == null){
            throw  new NoSuchEntityException("There is no Maintenance with ID = " + id + " in Database");
        }

        return maintenance;
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
