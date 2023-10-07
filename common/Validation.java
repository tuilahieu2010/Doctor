package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import model.Doctor;

/**
 *
 * @author hieu
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getIntLimit(String mess, int n, int m) {
        int result;
        while (true) {
            System.out.println(mess + ": ");
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < n && result > m) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please, enter a number between " + n + " and " + m);
            }
        }
    }

    public static String getString(String mess) {
        String result;
        while (true) {
            System.out.println(mess + ": ");
            result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.out.println("Please, enter again(Can not blank)");
        }
    }

    public static String getCode(String mess) {
        String result;
        while (true) {
            System.out.println(mess + ": ");
            result = sc.nextLine().trim();
            if(!result.isEmpty()){
                return result;
            }
            System.out.println("Please, enter again(Can not blank)");
        }
    }

    public static boolean checkCode(String code, HashMap<String, Doctor> dList) {
        if(dList.isEmpty()){
            return true;
        }
        Set<String> keyset = dList.keySet();
        for (String o : keyset) {
            if (code.equalsIgnoreCase(dList.get(o).getCode())) {
                return false;
            }
        }
        return true;
    }

    public static int getInt(String mess) {
        int result;
        while (true) {
            System.out.println(mess + ": ");
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("ID is digit(>0)");
            }
        }
    }

    public static boolean checkCodeExist(String code, HashMap<String, Doctor> dList) {
        Set<String> keyset = dList.keySet();
        for (String o : keyset) {
            if (code.equalsIgnoreCase(dList.get(o).getCode())) {
                return true;
            }
        }
        return false;
    }
}
