package ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class ButtonSave extends JButton implements ActionListener{
	boolean isZapisz;
	JButton button;
	
	public ButtonSave(boolean isZapisz) {
		this.isZapisz = isZapisz;
		if(isZapisz == true){
			button = new JButton("Zapisz");
		}
		else {
			button = new JButton("Zaladuj");
		}
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.isZapisz == true){
			System.out.println("Zapisuje!!!");
			
//			try {
//				File f = new File("stanGry.xml");
//				JAXBContext ctx = JAXBContext.newInstance(this);
//				Marshaller marshaller = ctx.createMarshaller();
//				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//				marshaller.marshal(button, System.out);
//				marshaller.marshal(button, f);
//			} catch (JAXBException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		else{
			System.out.println("Czytam!!!");
		}
		
		
	}
	
}