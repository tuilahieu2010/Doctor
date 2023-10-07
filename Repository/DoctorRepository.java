/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.DoctorDao;
import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author hieu
 */
public class DoctorRepository implements IDoctorRepository {

//    private 
    @Override
    public void addDoctor() throws Exception {
        if (DoctorDao.Instance().addDoctor()) {
            System.out.println("Add successfully");
        } else {
            System.out.println("Add failed ");
        }
    }

    @Override
    public void updateDoctor() throws Exception {
        if (DoctorDao.Instance().updateDoctor()) {
            System.out.println("Update successfully");
        } else {
            System.out.println("Update failed ");
        }
    }

    @Override
    public void deleteDoctor() throws Exception {
        if (DoctorDao.Instance().deleteDoctor()) {
            System.out.println("Delete successfully");
        } else {
            System.out.println("Delete failed ");
        }
    }

    @Override
    public HashMap<String, Doctor> searchDoctor() throws Exception {
        return DoctorDao.Instance().searchDoctor();
    }

}
