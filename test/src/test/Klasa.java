package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
class Dane{
//	@XmlAttribute(name="wiek")
	int wiek;
//	@XmlAttribute(name="imie")
	String imie;
	
	public Dane(){}
	
	public Dane(int wiek, String imie){
		this.wiek = wiek;
		this.imie = imie;
	}
	
//	@XmlAttribute(name="wiek")
//	public int getWiek(){
//		return wiek;
//	}
//	
//	@XmlAttribute(name="imie")
//	public String getImie(){
//		return imie;
//	}
}

@XmlRootElement(name = "point")
@XmlAccessorType (XmlAccessType.FIELD)
class Point{
//	@XmlAttribute(name="x")
	int x;
//	@XmlAttribute(name="y")
	int y;
	
	public Point(){}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
class Table{
	@XmlElement(name = "employee")
	Map<Point, Dane> dane = new HashMap<Point, Dane>();
	
	public Table(){}
	
	public void addData(Point point, Dane dane) {
		this.dane.put(point, dane);
	}
	
}


public class Klasa {
	
    public static void main(String[] args) throws JAXBException{
    	
    	Table tab = new Table();
    	tab.addData(new Point(0, 0), new Dane(12, "Ala"));
    	tab.addData(new Point(1, 1), new Dane(13, "Grzes"));
    	
    	try{
    		JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
    		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(tab, System.out);
//			jaxbMarshaller.marshal(dane[1], System.out);
    	}
    	catch (JAXBException e) {
			System.out.println(e);
		}
        
        
        
    }
    
    
}