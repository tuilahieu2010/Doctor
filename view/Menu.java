
package view;

import common.Validation;
import java.util.ArrayList;

/**
 *
 * @author hieu
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> mList;

    public Menu(String title, String[] ml) {
        this.title = title;
        mList = new ArrayList<>();
        for (String o : ml) {
            this.mList.add((T) o);
        }
    }

    public void display() {
        System.out.println("=========" + title + "=========");
        for (int i = 0; i < mList.size(); i++) {
            System.out.println(i + 1 + ". " + mList.get(i));
        }
    }

    public int getSelected() {
        display();
        return Validation.getIntLimit("Enter selection..", 1, mList.size() + 1);
    }

    public abstract void execute(int n) throws Exception;

    public void run() throws Exception {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mList.size()) {
                break;
            }
        }
    }
}
