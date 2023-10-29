import java.util.Arrays; 

public class TicTacToe {

   public static String[][] play (String[][] plateau , String player, int[] placement){
   
    if (plateau[placement[0]][placement[1]].equals(" ")){
        plateau[placement[0]][placement[1]] = player ;
    } else { 
        System.out.println("impossible de jouer  ici, un pion est déjà placé") ;
        printP(plateau);
    }
    
    return plateau ;
   }
   public static int convert(String a ){
    int b ;
     switch (a) {
        case "a":
            b = 0 ;
            break;
        case "b" :
            b = 1 ;
            break ;
        case "c" :
            b = 2 ;
            break ;
        default:
            b = 0 ;
            break;
    }
    return b ;
   }


   public static int[] inputPlay(String player) {
    String[] input = (System.console().readLine("Joueur " + player +", entrer le couple où vous voulez placer votre pion : ")).split(" ") ;
    if (input.length ==  2 ) {
        int[] result = {Integer.valueOf(input[1])-1 , convert(input[0]),} ;
        return result ;
    } else {
        System.out.println("erreur d'input");
        return inputPlay(player) ;
    }
    
   }

    public static void printP(String[][] plateau){
        System.out.println("+---------------+");
        System.out.println("| \\ | a | b | c |");
        System.out.println("|---+---+---+---|");
        System.out.println("| 1 | " + plateau[0][0] + " | " +  plateau[0][1] + " | " + plateau[0][2] +" |");
        System.out.println("|---+---+---+---|");
        System.out.println("| 2 | " + plateau[1][0] + " | " +  plateau[1][1] + " | " + plateau[1][2] +" |");
        System.out.println("|---+---+---+---|");
        System.out.println("| 3 | " + plateau[2][0] + " | " +  plateau[2][1] + " | " + plateau[2][2] +" |");
        System.out.println("+---------------+");
    }



    public static boolean win(String[][] plateau , String player){
        Object[] test = {player,player,player} ;
        Object[] testDG = {plateau[0][0],plateau[1][1],plateau[2][2]} ;
        Object[] testDD = {plateau[0][2],plateau[1][1],plateau[2][0]} ;
        for (int i = 0 ; i<3 ; i++) {
            Object[] testC = {plateau[0][i],plateau[1][i],plateau[2][i]} ;
            if (Arrays.equals(plateau[i], test)) { //lignes
                return true ;
            } else if (Arrays.equals(testC, test)) { //colonnes
                return true ;
            }
        }
        if (Arrays.equals(testDG, test) || Arrays.equals(testDD, test)) {
            return true ;
        }

        return false ;
    }
        
         
    
        
    public static void main(String[] args) {
        String[][] plateau =    {{" "," "," "},
                                {" "," "," "},
                                {" "," "," "}} ;
        String player = "x" ;
        printP(plateau);
        while (!(win(plateau,player))) {
            if (player.equals("o")){
                player = "x" ;
            } else {
                player = "o" ;
            }
            play(plateau, player, inputPlay(player));
            printP(plateau);
        }
        if (win(plateau,"o")) {
            System.out.println("Le joueur o a gagné");
        } else if (win(plateau,"x")) {
            System.out.println("Le joueur x a gagné");
        } else {
            System.out.println("égalité") ;
        }
    }
}