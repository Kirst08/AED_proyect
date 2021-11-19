package application;
public class Arbol {
    char nodo;
    Arbol Izq;
    Arbol Der;
    
    public Arbol(char d) {
        nodo = d;
        Izq = null;
        Der = null;
    }
}