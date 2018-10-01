
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

    public void delete(int idx) {
        appointments.remove(idx);
        fireIntervalRemoved(this, idx, idx);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public void change(Appointment a,int idx){
        appointments.set(idx, a);
        fireContentsChanged(this, idx, idx);
    }

}
