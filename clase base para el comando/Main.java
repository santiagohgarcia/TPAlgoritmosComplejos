import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    //FUENTES
    //http://notodojava.tredoo.com/ejecutar-comando-mediante-cmd-run-command-using-cmd/
    //http://lineadecodigo.com/java/como-ejecutar-un-comando-del-sistema-desde-java/
    public static void main(String[] args) {
	//CON ARGUMENTOS
	/*    try {
    	String [] cmd = {"shutdown","-s","-t", "10"}; //Comando de apagado en windows
    	Runtime.getRuntime().exec(cmd);
    } catch (IOException ioe) {
    	System.out.println (ioe);
    }*/
	
	//SIN ARGUMENTOS
	try {
		String cmd = "ping google.com"; 
		Process process = Runtime.getRuntime().exec(cmd); 
		
		InputStream inputstream = process.getInputStream();
		BufferedReader in = new BufferedReader(  
                        new InputStreamReader(process.getInputStream()));  
		String line = null;  
		while ((line = in.readLine()) != null) {  
		    System.out.println(line);  
		}  
		
	}catch (IOException ioe) {
		System.out.println (ioe);

	}

}
}