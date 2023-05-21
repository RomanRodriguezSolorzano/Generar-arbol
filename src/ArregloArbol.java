public class ArregloArbol {

    Recorrido recorridos;
    String[][] arbol;
    int cantidadNodos;

    public ArregloArbol(LeerDatos datos) {
        this.recorridos = datos.getDatosIngresados();
        this.cantidadNodos = recorridos.getRecorridoInorden().length + 1;
        arbol = new String[cantidadNodos][cantidadNodos];
        preLlenadoArbol();
        definirNodosCoincidencia();
    }

    void preLlenadoArbol() {
        for (int x = 1; x < cantidadNodos; x++) {
            arbol[0][x] = recorridos.getRecorridoInorden()[x - 1];
        }
        if (recorridos.isIngresoPreorden()) {

            for (int x = 1; x < cantidadNodos; x++) {
                arbol[x][0] = recorridos.getRecorridoPrePost()[x - 1];
            }
        } else {

            int y = 1;
            for (int x = cantidadNodos - 1; x > 0; x--) {
                arbol[y][0] = recorridos.getRecorridoPrePost()[x - 1];
                y++;
            }
        }

    }

    void definirNodosCoincidencia() {
        int posicionCoincidencia;
        for (int y = 1; y < cantidadNodos; y++) {
            posicionCoincidencia = posicionRaiz(y);
            arbol[y][posicionCoincidencia] = arbol[0][posicionCoincidencia];
            flechaAbajo(y,posicionCoincidencia,"│");
        }
        unirNodos();
    }

    void unirNodos() {
        int posicionRaiz;
        int posicionHijoIzquierdo;
        int posicionHijoDereho;
        for (int y = 1; y < cantidadNodos; y++) {
            posicionRaiz = posicionRaiz(y);
            posicionHijoIzquierdo = nodoIzquierda(y,posicionRaiz);
            if(posicionHijoIzquierdo!=999999){
                flechaIzquierda(y,posicionRaiz,posicionHijoIzquierdo);
                flechaAbajo(y,posicionHijoIzquierdo,"↓");
            }
            posicionHijoDereho = nodoDerecho(y,posicionRaiz);
            if(posicionHijoDereho!=999999){
                flechaDerecha(y,posicionRaiz,posicionHijoDereho);
                flechaAbajo(y,posicionHijoDereho,"↓");
            }

        }
    }
    int posicionRaiz(int y){
        int nodo = 0;
        for (int x = 1; !arbol[y][0].equals(arbol[0][x]); x++) {
            nodo++;
        }
        return nodo+1;
    }

    void flechaAbajo(int y, int nodo,String caracter){
        for (int t = y + 1; t < cantidadNodos&&arbol[t][nodo]==null; t++) {
            arbol[t][nodo] = caracter;
        }
    }
    void flechaIzquierda(int filaPadre, int posicionPadre, int posicionHijo){
        for (int t = posicionPadre - 1; t > posicionHijo; t--) {
            arbol[filaPadre][t] = "←";
        }
        if(arbol[filaPadre][posicionHijo]==null){
            arbol[filaPadre][posicionHijo] = "┍";
        }
    }

    void flechaDerecha(int filaPadre, int posicionPadre, int posicionHijo){
        for (int t = posicionPadre + 1; t < posicionHijo; t++) {
            arbol[filaPadre][t] = "→";
        }
        if(arbol[filaPadre][posicionHijo]==null){
            arbol[filaPadre][posicionHijo] = "┒";
        }
    }

    int nodoIzquierda(int fila, int PosicionRaiz){
        int posicionNodo = 0;
        boolean nodoEncontrado = false;
        boolean sobrepasaLimiteNodo = false;
        for(int y=fila+1;y<cantidadNodos&&!nodoEncontrado;y++){
            for(int x=PosicionRaiz-1;x>0&&!nodoEncontrado&&!sobrepasaLimiteNodo;x--){
                if(arbol[y][x]!=null){
                    if(arbol[y][x].equals("│")){
                        sobrepasaLimiteNodo =true;
                    }
                    else{
                        posicionNodo = x;
                        nodoEncontrado = true;
                    }
                }
            }
            sobrepasaLimiteNodo = false;
        }
        if(nodoEncontrado){
            return posicionNodo;
        }
        else{
            return 999999;
        }

    }


    int nodoDerecho(int fila, int PosicionRaiz){
        int posicionNodo = 0;
        boolean nodoEncontrado = false;
        boolean sobrepasaLimiteNodo = false;
        for(int y=fila+1;y<cantidadNodos&&!nodoEncontrado;y++){
            for(int x=PosicionRaiz+1;x<cantidadNodos&&!nodoEncontrado&&!sobrepasaLimiteNodo;x++){
                if(arbol[y][x]!=null){
                    if(arbol[y][x].equals("│")){
                        sobrepasaLimiteNodo =true;
                    }
                    else{
                        posicionNodo = x;
                        nodoEncontrado = true;
                    }
                }
            }
            sobrepasaLimiteNodo = false;
        }
        if(nodoEncontrado){
            return posicionNodo;
        }
        else{
            return 999999;
        }

    }
    void imprimirArbol() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                if (arbol[i][j] == null) {
                    sb.append(" ");
                } else {
                   if(!arbol[i][j].equals("│")){
                        sb.append(arbol[i][j]);
                   }
                }

                if (j < cantidadNodos - 1) {
                    sb.append("\t");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
