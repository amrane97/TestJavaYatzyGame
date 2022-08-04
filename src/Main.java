import java.util.*;

public class Main {



    public static Integer lancerDes() {
        Random rand = new Random();
        int max = 6;
        int min = 1;
        //generate random values from 1-6
        Integer int_random = rand.nextInt(max)+min;
        return int_random;
    }

    public static Integer[] tourDes() {

        Integer[] tab = new Integer[5];

        for (int i = 0; i < 5; i++){
            tab[i] = lancerDes();
        }
        System.out.println("resultat du lancé : " + Arrays.toString(tab) +"\n");
        return tab;
    }

    public static int paire() {
        Integer[] tab = tourDes();

        int score = 0;

        Arrays.sort(tab, Collections.reverseOrder());

        for (int i = 0; i < tab.length; i++){
            for (int k = 1; k < tab.length; k++){
                if (tab[i] == tab[k]) {
                    score = tab[k]*2;
                    // mais si il y'a un 3eme du meme
                } else {
                    score = 0;
                }
            }
        }
        return score;
        // le plus grand n'est pas respecter mais bon c'est un debut !
    }

    public static int twoPaires() {
        Integer[] tab = tourDes();
        int max = 0;
        int score = 0;
        for (int i = 0; i < tab.length; i++){
            for (int k = 1; k < tab.length; k++){
                if (tab[i] == tab[k]) {
                    score += tab[k]*2;

                } else {
                    score += 0;
                }
            }
        }
        return score;
    }


    public static int threeOfKind() {
        Integer[] tab = tourDes();

        int score = 0;

        Arrays.sort(tab, Collections.reverseOrder());

        for (int i = 0; i < tab.length; i++){
            for (int k = 2; k < tab.length; k++){
                if (tab[i] == tab[k] && tab[i] == tab[k-1]) {
                    score = tab[k]*3;
                } else {
                    score = 0;
                }
            }
        }
        return score;
        // le plus grand n'est pas respecter mais bon c'est un debut !
    }



    public static int fourOfKind() {
        Integer[] tab = tourDes();

        int score = 0;

        Arrays.sort(tab, Collections.reverseOrder());

        for (int i = 0; i < tab.length; i++){
            for (int k = 3; k < tab.length; k++){
                if (tab[i] == tab[k] && tab[i] == tab[k-1] && tab[i] == tab[k-2]) {
                    score = tab[k]*4;
                } else {
                    score = 0;
                }
            }
        }
        return score;
        // le plus grand n'est pas respecter mais bon c'est un debut !
    }

    public static int smallLargeStraight() {

        int score = 0;

        Integer[] tab = tourDes();
        Arrays.sort(tab);

        for (int i = 0; i < tab.length; i++)
            if(tab [i] == i+1) {
                score = 15;
            } else if (tab[i] == i+2) {
                score = 20;
            } else {
                score = 0;
            }
        return score;
    }

    public static int fullHouse() {

        Integer[] tab = tourDes();

        int score = 0;
        int pointPaire = 0;
        int pointTOK = 0;

        boolean paire = false;
        boolean three_of_kind = false;
//***********************paire********************************
        for (int i = 0; i < tab.length; i++){
            for (int k = 1; k < tab.length; k++){
                if (tab[i] == tab[k]) {
                    paire = true;
                    pointPaire = tab[i] * 2;
                }
            }
        }
//************************************************************
//**************************three Of Kind**********************

        for (int i = 0; i < tab.length; i++){
            for (int k = 2; k < tab.length; k++){
                if (tab[i] == tab[k] && tab[i] == tab[k-1]) {
                    three_of_kind = true;
                    pointTOK = tab[i]*3;
                }
            }
        }
        //*************************************************************
        if (three_of_kind == true && paire == true) {
            score = pointPaire + pointTOK;
        }
        return score;
    }












    public static void main(String[] args) {

        int score = 0;

        //Joueur joueur1 = new Joueur("amine", 18);
        //Joueur joueur2 = new Joueur("amrane", 25);

        //Scanner myObj = new Scanner(System.in);




        //System.out.print("joueur 1 : veuillez inserer votre nom : ");
        //String joueur1 = myObj.nextLine();

        //System.out.print("\n joueur 2 : veuillez inserer votre nom : ");
        //String joueur2 = myObj.nextLine();

        //smallLargeStraight();

        //pour ne choisir qu'une seule fois un mode
        boolean paire = false;
        boolean chance = false;
        boolean yatzy = false;
        boolean one_to_six = false;
        boolean two_paires = false;
        boolean three_of_kind = false;
        boolean four_of_kind = false;
        boolean small_straight = false;
        boolean large_straight = false;
        boolean full_house = false;



        while (!paire || !chance || !yatzy || !one_to_six
        || !two_paires || !three_of_kind || !four_of_kind
                || !small_straight || !large_straight || !full_house) {

            Scanner myObj2 = new Scanner(System.in);

            System.out.print("choisissez le mode : ");

            if (myObj2.nextLine().equals("chance") && chance!=true) {

                Integer[] tourChance = tourDes();
                chance = true;

                for (int i = 0; i < tourChance.length; i++){
                    score += tourChance[i];
                }
                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("yatzy") && !yatzy) {


                Integer[] tourYatzy = tourDes();
                yatzy = true;


                if (tourYatzy[0] == tourYatzy[1] && tourYatzy[1] == tourYatzy[2] &&
                        tourYatzy[2] == tourYatzy[3] && tourYatzy[3] == tourYatzy[4]){

                    score += 50;
                }
                System.out.println("votre score est maintenant : " + score +" pts");

            }

             else if (myObj2.nextLine().equals("paire") && !paire) {

                score += paire();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("two pairs") && !two_paires) {

                score += twoPaires();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("three of kind") && !three_of_kind) {

                score += threeOfKind();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("four of kind") && !four_of_kind) {

                score += fourOfKind();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("small straight") && !small_straight ) {

                score += smallLargeStraight();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("large straight") && !large_straight) {

                score += smallLargeStraight();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else if (myObj2.nextLine().equals("full house") && !full_house) {

                score += fullHouse();

                System.out.println("votre score est maintenant : " + score +" pts");

            } else {
                System.out.println("!! Error !! soit cette commande n'existe pas ou bien vous avez déja jouer ce mode");
            }
        }
    }
}
