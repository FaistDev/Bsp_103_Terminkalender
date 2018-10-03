
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben
 */
public class AppointmentModell extends AbstractListModel {

    private ArrayList<Appointment> appointments = new ArrayList<>();

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int index) {
        return appointments.get(index);
    }

    public void add(Appointment a) {
        appointments.add(a);
        fireIntervalAdded(this, appointments.size() - 1, appointments.size() - 1);
    }

    public void delete(int idx) throws Exception{
        appointments.remove(idx);
        fireIntervalRemoved(this, idx, idx);
    }

    public ArrayList<Appointment> getList() {
        return appointments;
    }
    public void change(Appointment a,int idx){
        appointments.set(idx, a);
        fireContentsChanged(this, idx, idx);
    }
    
    public void saveData() throws Exception {
        File f = new File("./data.bin");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Appointment s : appointments) {
            oos.writeObject(s);
        }
        oos.flush();
    }
    
    public void loadData() throws Exception {
        File f = new File("./data.bin");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object s = null;
        while ((s = ois.readObject()) != null) {
            try {
                add((Appointment) s);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }

        }
    }

}
