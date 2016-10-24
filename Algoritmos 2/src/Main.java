import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {

	public static void main(String[] args) throws IOException {
	
		XStream xstream = new XStream(new StaxDriver()); // does not require XPP3 library starting with Java 6

        //Clase TP-ACyEDA
    	xstream.alias("TP-ACyEDA", TP_ACyEDA.class);
    	xstream.addImplicitCollection(TP_ACyEDA.class, "apps");
    	
        //Clase Aplicacion
    	xstream.alias("app", Aplicacion.class);
    	xstream.useAttributeFor(Aplicacion.class, "nombre");
    	xstream.aliasField("title", Aplicacion.class, "nombre");
    	xstream.addImplicitCollection(Aplicacion.class, "configuraciones");
    	
    	//Clase Configuracion
    	xstream.alias("config", Configuracion.class);
    	xstream.useAttributeFor(Configuracion.class, "nombre");
    	xstream.useAttributeFor(Configuracion.class, "command");
    	xstream.useAttributeFor(Configuracion.class, "params");
    	xstream.aliasField("title", Configuracion.class, "nombre");
    	xstream.addImplicitCollection(Configuracion.class, "controles");
    	
    	//Clase Control FileChooser
    	xstream.alias("controlFileChooser", ControlFileChooser.class);
    	xstream.useAttributeFor(ControlFileChooser.class, "name");
    	xstream.useAttributeFor(ControlFileChooser.class, "label");
    	xstream.aliasField("def-dir", ControlFileChooser.class, "defaultDir");
    	xstream.aliasField("tipo-arch", ControlFileChooser.class, "tipoArch");
    	
    	//Clase Control ComboBox
    	xstream.alias("controlComboBox", ControlComboBox.class);
    	xstream.useAttributeFor(ControlComboBox.class, "name");
    	xstream.useAttributeFor(ControlComboBox.class, "label");
    	xstream.addImplicitCollection(ControlComboBox.class, "options");
    	xstream.alias("option", Integer.class);
    	

    	//Clase Control Tiempo
    	xstream.alias("controlTime", ControlTime.class);
    	xstream.useAttributeFor(ControlTime.class, "name");
    	xstream.useAttributeFor(ControlTime.class, "label");
    	 
    	//Clase Control Number
    	xstream.alias("controlNumber", ControlNumber.class);
    	xstream.useAttributeFor(ControlNumber.class, "name");
    	xstream.useAttributeFor(ControlNumber.class, "label");
        
    	//Clase Control Time Interval
    	xstream.alias("controlTimeInterval", ControlTimeInterval.class);
    	xstream.useAttributeFor(ControlTimeInterval.class, "name");
    	xstream.useAttributeFor(ControlTimeInterval.class, "label");
    	xstream.useAttributeFor(ControlTimeInterval.class, "interval");
    	xstream.alias("timeLow", ControlTime.class);
    	xstream.alias("timeHigh", ControlTime.class);
    	
    	//Clase Control Time + Time
    	xstream.alias("controlTimePlusTime", ControlTimePlusTime.class);
    	xstream.useAttributeFor(ControlTimePlusTime.class, "name");
    	xstream.useAttributeFor(ControlTimePlusTime.class, "label");
    	xstream.alias("timeLow", ControlTime.class);
    	xstream.alias("timeToSum", ControlTime.class);
    	
    	//Clase Control Date
    	xstream.alias("controlDate", ControlDate.class);
    	xstream.useAttributeFor(ControlDate.class, "name");
    	xstream.useAttributeFor(ControlDate.class, "label");
    	
    	//Clase Control Date
    	xstream.alias("controlDateInterval", ControlDateInterval.class);
    	xstream.useAttributeFor(ControlDateInterval.class, "name");
    	xstream.useAttributeFor(ControlDateInterval.class, "label");    	

    	//Clase Control Date Interval
    	xstream.alias("controlDateInterval", ControlDateInterval.class);
    	xstream.useAttributeFor(ControlDateInterval.class, "name");
    	xstream.useAttributeFor(ControlDateInterval.class, "label");
    	xstream.alias("dateLow", ControlDate.class);
    	xstream.alias("dateHigh", ControlDate.class);

    	//Clase Control Date + Days
    	xstream.alias("controlDatePlusDays", ControlDatePlusDays.class);
    	xstream.useAttributeFor(ControlDatePlusDays.class, "name");
    	xstream.useAttributeFor(ControlDatePlusDays.class, "label");
    	xstream.alias("dateLow", ControlDate.class);
    	xstream.alias("days", ControlNumber.class);

    	//Clase Control Text
    	xstream.alias("controlText", ControlText.class);
    	xstream.useAttributeFor(ControlText.class, "name");
    	xstream.useAttributeFor(ControlText.class, "label");
    	    	
        String filePath = "./../XML_Final.xml";
    	String xml = new String(Files.readAllBytes(Paths.get(filePath)));

    	TP_ACyEDA tp = (TP_ACyEDA)xstream.fromXML(xml);
    	
    	new CPrincipal(new VPrincipal(),tp);

	}
	
	
	

}
