

public class Personagem {

    String nome;
    int vida;
    int forca;

    public static void ataque(Personagem atacante, Personagem defensor){
        defensor.vida += - atacante.forca;
    }
        
}
