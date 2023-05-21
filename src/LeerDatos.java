import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeerDatos {

    private Recorrido recorrido;
    private String [] lineas = new String[4];
    public LeerDatos(){
        recorrido = new Recorrido();
        LeerArchivo();
        AsignarRecorrigos();
    }

    void LeerArchivo(){
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("src/datos.txt"));
            for (int x=0;x<4;x++){
                lineas[x] = archivo.readLine();
            }
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("No existe un archivo con los datos de recorrido");
        } catch (IOException io){
            System.out.println("El archivo esta vacio");
        }
    }

    void AsignarRecorrigos(){
        Pattern patron = Pattern.compile("pre", Pattern.CASE_INSENSITIVE);
        Matcher coincide = patron.matcher(lineas[2]);
        if(!coincide.find()) {
            recorrido.setIsPreorden(false);
        }
        recorrido.setRecorridoInorden(lineas[1].strip().split(","));
        recorrido.setRecorridoPrePost(lineas[3].strip().split(","));
    }

    /*
    void leerInorden(){
        String [] nodos = JOptionPane.showInputDialog("Ingresa el recorrido Inorden separado con comas x1,x2,x3...").strip().split(",");
        recorrido.setRecorridoInorden(nodos);
    }

    void leerTipoRecorrido(){
        Object[] options = {"Preorden", "PostOrden"};
        int n = JOptionPane.showOptionDialog(null,
                "¿Que tipo de recorrido vas a ingresar",
                "Tipo de recorrido",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        if(n == 1){
            recorrido.setIsPreorden(false);
        }
    }

    void leerRecorridoPrePost(){
        String tipoRecorrido = "Preorden";
        if(!recorrido.isIngresoPreorden()){
            tipoRecorrido = "Postorden";
        }
        String [] nodos = JOptionPane.showInputDialog("Ingresa el recorrido "+tipoRecorrido + " separado con comas x1,x2,x3...").strip().split(",");
        recorrido.setRecorridoPrePost(nodos);
    }
    */
    Recorrido getDatosIngresados(){
        return this.recorrido;
    }

}
