import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RPG {
    public static void main(String[] args) throws InterruptedException {

        Scanner leia = new Scanner(System.in);

        Random random = new Random();

        Personagem player = new Personagem();

        Personagem monstro = new Personagem();

        player.vida = 100;
        monstro.vida = 100;

        player.forca = random.nextInt(1, 11);

        System.out.println("Averum é um mundo que foi devastado pela Grande Guerra Celestial que consumiu a maior parte da mana existente.");

        Thread.sleep(1000);

        //System.out.println("Qual é o seu nome? ");
        
        //SEM O SCANNER.
        //String primeira = leia.nextLine();
        String primeira = JOptionPane.showInputDialog("Qual o seu nome? ");
        player.nome = primeira.substring(0, 1).toUpperCase() + primeira.substring(1);
        
        player.forca = random.nextInt(1, 11);
        monstro.forca = random.nextInt(1,11);

        System.out.println("Seja bem vindo " + player.nome + ", a sua forca é " + player.forca + ".");

        Thread.sleep(1000);

        System.out.println("Você é um guerreiro, porém perdeu a sua espada vá encontre algo para se defender.");

        Thread.sleep(1000);

        System.out.println("Deseja explorar o mapa [S/N]?");
        String pergunta = leia.nextLine().substring(0,1).toUpperCase();

        if (pergunta.equals("S")){
            System.out.println("Demora muito, mas você chega em uma cidade destruída pela guerra e decide vasculhar uma loja de armas, você encontra uma espada, deseja pegá-la [S/N]?");
            pergunta = leia.nextLine().substring(0,1).toUpperCase();

            if (pergunta.equals("S")){
                System.out.println("Agora com a espada você sente mais confiante e seguro e decide explorar mais.");
                player.forca += 10;
                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                System.out.println("Sua forca aumentou para " + player.forca + ".");
                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                Thread.sleep(1000);
                System.out.println("Você vê uma caverna, quer entrar [S/N]?");
                pergunta = leia.nextLine().substring(0,1).toUpperCase();

                if (pergunta.equals("S")){
                    System.out.println("Você entra na caverna e de repente...");
                    System.out.println("Você encontra um ogro com um tesouro deseja abatê-lo [S/N]?");
                    pergunta = leia.nextLine().substring(0,1).toUpperCase();

                    if (pergunta.equals("S")){
                        

                        //LUTA do monstro com o player
                        while (monstro.vida > 0 && player.vida > 0){
                            int dado = random.nextInt(1, 7);
                            
                            // SE DER 1 E 2 O ATAQUE ERRA
                            if (dado == 1) {
                                System.out.println("==================================================");
                                System.out.println("Voce errou o ataque.");
                                System.out.println("==================================================");
                                Thread.sleep(1000);
                            }

                            if (dado == 2){
                                System.out.println("==================================================");
                                System.out.println("O ogro errou o ataque.");
                                System.out.println("==================================================");
                                Thread.sleep(1000);
                            }

                            // SE DER 3 E 4 O ATAQUE ACERTA E DESCONTA DA VIDA    
                            if (dado == 3){
                                Personagem.ataque(player, monstro);
                                System.out.println("==================================================");
                                System.out.println(player.nome + " acertou o ataque de " + player.forca + " de dano!");
                                System.out.println("==================================================");
                                Thread.sleep(1000);
                            }

                            if (dado == 4){
                                Personagem.ataque(monstro, player);
                                System.out.println("==================================================");
                                System.out.println("O ogro acertou o ataque " + monstro.forca + " de dano.");
                                System.out.println("==================================================");
                                Thread.sleep(1000);
                            }
                            
                            //SE DER 5 E 6 O ATAQUE ACERTA E É CRÍTICO DESCONTANDO DA VIDA
                            if (dado == 5){
                                int criticoPlayer = random.nextInt(1, 11);
                                player.forca += + criticoPlayer;
                                Personagem.ataque(player, monstro);
                                System.out.println("==================================================");
                                System.out.println(player.nome + " acertou um ataque critico! Deu " + player.forca + " de dano.");
                                System.out.println("==================================================");
                                Thread.sleep(1000);
                            }

                            if (dado == 6){
                                int criticoMonstro = random.nextInt(1, 21);
                                monstro.forca = monstro.forca + criticoMonstro;
                                Personagem.ataque(monstro, player);
                                System.out.println("==================================================");
                                System.out.println("O ogro acertou um ataque critico! Deu "+ monstro.forca + " de dano.");
                                System.out.println("==================================================");
                                Thread.sleep(1000);

                            }

                        } if (player.vida > 0){
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                            System.out.println("Parabéns você matou o ogro! Ganhou o tesouro!");
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                            Thread.sleep(1000);
                            System.out.println(player.nome + " pega todo o tesouro e caminha todo feliz.");
                            Thread.sleep(1000);
                            System.out.println("Você vê um mercador que oferece uma armadura em troca do tesouro, deseja trocar o tesouro pela armadura [S/N]?");
                            pergunta = leia.nextLine().substring(0,1).toUpperCase();

                            if (pergunta.equals("S")){
                                player.vida += + 10;
                                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                                System.out.println( player.nome + " ganhou 10 pontos de proteção.");
                                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                                
                            } else {
                                System.out.println("A troca não é feita, mas depois você fica se lamentando por não ter trocado.");
                            
                                //PODE CONTINUAR DAQUI
                            } 

                        } else {
                            player.vida = 0;
                            System.out.println(player.nome + " morreu para o ogro! GAME OVER!");
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                            System.out.println(player.nome + ", morreu e estava com "+ player.forca + " de força.");
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~"); 
                        }

                    } else {
                        System.out.println(player.nome + " deixa o ogro pra lá e continua sua jornada para encontrar alimento.");

                        Thread.sleep(1000);
                    
                        System.out.println("Logo se depara com uma senhora gentil, de uns 80 anos, ela lhe oferece uma maçã.");
                        System.out.println("Pegar a maçã [S/N]?");
                        pergunta = leia.nextLine().substring(0,1).toUpperCase();

                        if (pergunta.equals("N")){
                            System.out.println("Você sabiamente recusa presente de estranhos.");
                        
                            //PODE CONTINUAR DAQUI

                        } else {
                            player.vida = 0;
                            System.out.println("Você comeu a maçã e morreu envenenado, GAME OVER!");
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                            System.out.println(player.nome + ", morreu e estava com "+ player.forca + " de força.");
                            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                        }
                    } 

                } else { 
                    System.out.println(player.nome + " prossegue adiante pois tem medo de cavernas...");

                    //PODE CONTINUAR DAQUI
                }

            } else {
                player.vida = 0;
                System.out.println("Você está sem nenhuma arma e é atacado por um grupo de orcs e acaba morrendo, GAME OVER!");
                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
                System.out.println(player.nome + ", morreu e estava com "+ player.forca + " de força.");
                System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
            }

        } else {
            player.vida = 0;
            System.out.println("Você está sem nenhuma arma e é atacado por uma matilha de lobos e acaba morrendo, GAME OVER!");
            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
            System.out.println(player.nome + ", morreu e estava com "+ player.forca + " de força.");
            System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
        }
        leia.close();
    }
}
