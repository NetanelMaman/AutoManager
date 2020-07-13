import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ChooseCarPanel extends JPanel implements ActionListener {

	private ArrayList<CarModel> cars;
	
	public ChooseCarPanel(ArrayList<CarModel> cars) {
		this.cars = cars;
		String[] models = new String[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
		//	models[i] = cars.get(i).
		}
		//JComboBox combo = new JComboBox(ids);
//		combo.setMaximumRowCount(10);
//		combo.setFont(new Font("Arial", Font.PLAIN, 50));
//		combo.addActionListener(this);
		//add(combo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
