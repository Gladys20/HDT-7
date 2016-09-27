/**
 * @author Grupo 3  
 * @author Edgar Ramírez 15236
 * @author Gladis de la Roca
 * @author Robbin Woods
 * @version 26/09/2016
 * @Description: 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Texto {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Binarytree<Node<String,String>>raiz;
        ArrayList <String> oracion = new ArrayList<String>();
    
    public Texto(){
        raiz=new Binarytree<Node<String,String>>(null, null, null, null);
        llenarDiccio();
  
        traducirOracion();
    }
    
    public void llenarDiccio(){
        ArrayList<String> frase= new ArrayList<String>();
        ArrayList<Node<String,String> >asociaciones= new ArrayList<Node<String,String>>();
        //codigo tomado de internet
        try {
           // Lee el archivo
           archivo = new File ("C:\\Users\\edgar\\Documents\\GitHub\\HTDT 7\\HDT-7\\diccionario.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura
           
           String linea;
           int ind=0;
           while((linea=br.readLine())!=null){
        	   frase.add(linea);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // en finally se cierra 
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        //termina codigo tomado dd internet
        
        
        for(int i=0; i<frase.size()-1;i++){
               int pos=frase.get(i).indexOf(',');
               String p_ingles=frase.get(i).substring(0,pos);
               String p_espaniol=frase.get(i).substring(pos+1,frase.get(i).length());
               asociaciones.add(new Node(p_ingles, p_espaniol));
        }
        
        raiz.setValue(asociaciones.get(0));
        for (int i=1; i<asociaciones.size(); i++){
            insertarNodo(raiz, asociaciones.get(i));
        }
     }
    
    public void insertarNodo(Binarytree<Node<String,String>> padre, Node<String,String> dato)
    {
       
    	Node<String,String> asociacion=padre.value();
        String llavePadre=asociacion.getKey();
        String llaveDato=dato.getKey();
        int num=llavePadre.compareToIgnoreCase(llaveDato);
        if(num>0 && padre.left()==null){
           
            padre.setLeft(new Binarytree<Node<String,String>>(null, null, null,null));
            padre.left().setValue(dato);
        }else if(padre.left()!=null){
            
            insertarNodo(padre.left(),dato);
        }
        
        if(num<0 && padre.right()==null){
            
            padre.setRight(new Binarytree<Node<String,String>>(null, null, null,null));
            padre.right().setValue(dato);
        }else if(padre.right()!=null){
            
            insertarNodo(padre.right(),dato);
        }
    }
    
     public String traducirPalabra(Binarytree<Node<String,String>> padre, String palabra)
{
	String p_Traducida = "";
	Node<String,String> asociacion=padre.value();
       	String llavePadre=asociacion.getKey();
        
	int num=llavePadre.compareToIgnoreCase(palabra);
	if(num==0){
		p_Traducida=padre.value().getValue();
	}
	if(num<0){
            if(padre.right()!=null){
                p_Traducida=traducirPalabra(padre.right(),palabra);
            }else{
                return ("*"+palabra+"*");
            }
	}
	if(num>0){
            if(padre.left()!=null){
                    p_Traducida=traducirPalabra(padre.left(),palabra);
            }else{
                    return ("*"+palabra+"*");
            }
		
	}

	return p_Traducida;
    }

     private void leerOracion(){
	String palabras="";
	//Codigo tomado de internet
        try {
           //lee el archivo
           archivo = new File ("C:\\Users\\edgar\\Documents\\GitHub\\HTDT 7\\HDT-7\\texto.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int ind=0;
           while((linea=br.readLine())!=null){
              	palabras=linea;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally se cierra
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }

	while(palabras.compareTo("")!=0){
	int lugar=palabras.indexOf(' ');
            if(lugar!=-1){
                    oracion.add(palabras.substring(0,lugar));
                    palabras=palabras.substring(lugar+1);
            }else{
                    oracion.add(palabras);
                    palabras="";
            }
        }
     }
     
     
    public void traducirOracion(){
        leerOracion();
        String resultado="";
        for(int i=0; i<oracion.size(); i++){
                resultado+=traducirPalabra(raiz, oracion.get(i).trim())+" ";
        }
        System.out.println(resultado);
    }



}
