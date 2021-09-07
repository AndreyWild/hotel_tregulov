package com.senla.hotel.service;

import com.senla.hotel.api.dao.IMaintenanceDao;
import com.senla.hotel.api.service.IMaintenanceService;
import com.senla.hotel.model.entities.Maintenance;
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
        return maintenanceDao.getById(id);
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
