public class Main {
    public static void main(String[] args) {
        LeerDatos datos = new LeerDatos();
        ArregloArbol arbol;
        //datos.leerInorden();
        //datos.leerTipoRecorrido();
        //datos.leerRecorridoPrePost();
        arbol = new ArregloArbol(datos);
        arbol.imprimirArbol();
    }
}