package com.senla.hotel.dao;

import com.senla.hotel.api.dao.IMaintenanceDao;
import com.senla.hotel.model.entities.Maintenance;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {
    @Override
    Class<Maintenance> getGenericClass() {
        return Maintenance.class;
    }
}
