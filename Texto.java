import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Texto{
	
public String LeerArchivo(String direccion){
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		
		try {
		archivo = new File (direccion);
		fr = new FileReader (archivo);
		br = new BufferedReader(fr);

		
		linea = br.readLine();
			
		
			
		
				}//FIN DEL TRY
		   catch(Exception e){
		      System.err.println("El archivo está vacío. No hay ninguna instrucción");
		     
		   }
		
		
		return linea;
	}
	
}
