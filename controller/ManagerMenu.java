/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Set;
import model.Doctor;
import repository.DoctorRepository;
import repository.IDoctorRepository;
import view.Menu;

/**
 *
 * @author hieu
 */
public class ManagerMenu extends Menu<String>{
    
    private final IDoctorRepository doctorRepository;
    static String[] op = {"Add Doctor", "Update Doctor ", "Delete Doctor ", "Search Doctor", "Exit"};

    public ManagerMenu() {
        super("Doctor Management ", op);
        doctorRepository = new DoctorRepository();
    }

    @Override
    public void execute(int n) throws Exception{
        switch (n) {
            case 1: {
                doctorRepository.addDoctor();
                break;
            }
            case 2: {
                doctorRepository.updateDoctor();
                break;
            }
            case 3: {
                doctorRepository.deleteDoctor();
                break;
            }
            case 4: {
                HashMap<String, Doctor> d = doctorRepository.searchDoctor();
                Set<String> keySet = d.keySet();
                for (String o : keySet) {
                    System.out.println(d.get(o));
                }
                break;
            }
            case 5:
                System.exit(0);
            default:
                System.out.println("Please, enter again!");
        }
    }
}
