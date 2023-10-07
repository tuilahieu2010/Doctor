package dataAccess;

import common.Validation;
import java.util.HashMap;
import java.util.Set;
import model.Doctor;

/**
 *
 * @author hieu
 */
public class DoctorDao {

    private static DoctorDao instance = null;

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    HashMap<String, Doctor> dList = new HashMap<>();

    public boolean addDoctor() throws Exception {
        System.out.println("--------- Add Doctor ----------");
        boolean flag = false;
        try {
            String code = Validation.getCode("Enter code");
            if (!Validation.checkCode(code, dList)) {
                throw new Exception("Doctor code is duplicate");
            }
            String name = Validation.getString("Enter name");
            String specialization = Validation.getString("Enter specialization");
            int availability = Validation.getInt("Enter availability");
            Doctor d = new Doctor(code, name, specialization, availability);
            dList.put(code, d);
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return flag;
    }

    public boolean updateDoctor() throws Exception {
        System.out.println("--------- Update Doctor -------");
        boolean flag = false;
        try {
            if (dList.isEmpty()) {
                throw new Exception("Doctor code doesn’t exist");
            } else {
                String code = Validation.getString("Enter code");
                if (!Validation.checkCodeExist(code, dList)) {
                    throw new Exception("Doctor code doesn’t exist");
                }
                String name = Validation.getString("Enter name");
                String specialization = Validation.getString("Enter specialization");
                int availability = Validation.getInt("Enter availability");
                Doctor d = new Doctor(code, name, specialization, availability);
                dList.replace(code, d);
                flag = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public boolean deleteDoctor() throws Exception {
        System.out.println("--------- Delete Doctor -------");
        boolean flag = false;
        try {
            if (dList.isEmpty()) {
                throw new Exception("Doctor code doesn’t exist");
            } else {
                String code = Validation.getString("Enter code");
                if (!Validation.checkCodeExist(code, dList)) {
                    throw new Exception("Doctor code doesn’t exist");
                }
                dList.remove(code);
                flag = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    public HashMap<String, Doctor> searchDoctor() throws Exception {
        System.out.println("---------- Search Doctor --------");
        HashMap<String, Doctor> findDoctor = new HashMap<>();
        try {
            if (dList.isEmpty()) {
                throw new Exception("Database does not exist");
            }
            Set<String> keySet = dList.keySet();
            String input = Validation.getString("Enter text");
            for (String o : keySet) {
                if ((dList.get(o).getCode().contains(input)) || (dList.get(o).getName().contains(input)) || (dList.get(o).getSpecialization().contains(input))) {
                    findDoctor.put(dList.get(o).getCode(), dList.get(o));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return findDoctor;
    }
}
