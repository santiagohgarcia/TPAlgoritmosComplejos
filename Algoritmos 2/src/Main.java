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
    	
    	//Clase Control
    	xstream.alias("control", Control.class);
    	xstream.useAttributeFor(Control.class, "name");
    	xstream.useAttributeFor(Control.class, "controlClass");
    	xstream.useAttributeFor(Control.class, "label");
    	
        String filePath = "C:/Users/Santiago/Programming/TPAlgoritmos/TPAlgoritmosComplejos/XML_NuevoTest.xml";
    	String xml = new String(Files.readAllBytes(Paths.get(filePath)));
    	
    	TP_ACyEDA tp = (TP_ACyEDA)xstream.fromXML(xml);
    	
    	new Controlador(new VentanaPrincipal(),tp);

	}
	
	
	

}
