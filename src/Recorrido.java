public class Recorrido {
    private String [] recorridoInorden;
    private String [] recorridoPrePost;

    private boolean ingresoPrePost;

    public Recorrido() {
        this.ingresoPrePost   = true;
    }

    public Recorrido(String [] recorridoInorden, String [] recorridoPrePost, boolean ingresoPrePost) {
        this.recorridoInorden = recorridoInorden;
        this.recorridoPrePost = recorridoPrePost;
        this.ingresoPrePost   = ingresoPrePost;
    }

    public String [] getRecorridoInorden() {
        return recorridoInorden;
    }

    public void setRecorridoInorden(String [] nodos) {
        this.recorridoInorden = nodos;
    }

    public String [] getRecorridoPrePost() {
        return recorridoPrePost;
    }

    public void setRecorridoPrePost(String[] nodos) {
        this.recorridoPrePost = nodos;
    }

    public boolean isIngresoPreorden() {
        return this.ingresoPrePost;
    }

    public void setIsPreorden(boolean isPreorden) {
        this.ingresoPrePost = isPreorden;
    }
}
