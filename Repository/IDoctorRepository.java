package repository;

import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author Hieu
 */
public interface IDoctorRepository {
    void addDoctor () throws Exception;
    void updateDoctor () throws Exception;
    void deleteDoctor () throws Exception;
    HashMap<String, Doctor> searchDoctor () throws Exception;
}
