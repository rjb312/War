/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author ryan
 */
class Deck {

    public static ArrayList<Integer> readCSV() throws FileNotFoundException {
        ArrayList<Integer> values = new ArrayList<>();
        String line;
        File f = new File("Deck.txt");
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            String[] nums = line.split(",");
            for (int i = 0; i < nums.length - 1; i++) {
                int value = Integer.parseInt(nums[i]);
                values.add(value);
            }
        }

        class PlayerHand {

            public ArrayList<Integer> playerHand(ArrayList<Integer> player) {

                return player;
            }
        }
        return values;
    }
}

public class War {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        Deck gameDeck = new Deck();
        //System.out.println(Deck.readCSV());
        ArrayList<Integer> newDeck = Deck.readCSV();
        Collections.shuffle(newDeck);
        //System.out.println(newDeck);
        ArrayList<Integer> player1Hand = new ArrayList<>();
        ArrayList<Integer> player2Hand = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            player1Hand.add(newDeck.get(i));
        }
        for (int i = 26; i < newDeck.size(); i++) {
            player2Hand.add(newDeck.get(i));
        }
        int rounds = 0;
        int cardNum1 = player1Hand.size();
        int cardNum2 = player2Hand.size();
        System.out.println("Welcome to war! Type 1 to start the game.");
        while (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            String confirm = input.nextLine();
            if (confirm.equals("1")) {
                rounds = rounds + 1;
                System.out.println("This is Round " + rounds + " of the war!");
                //might need to go later on in code
                System.out.println("Player One has " + cardNum1 + " cards!");
                System.out.println("Player Two has " + cardNum2 + " cards!");
                System.out.println("Ready! Set! Go!");
                if (player1Hand.get(0) > player2Hand.get(0)) {
                    int i = player1Hand.get(0);
                    int j = player2Hand.get(0);
                    player1Hand.remove(0);
                    player2Hand.remove(0);
                    player1Hand.add(i);
                    player1Hand.add(j);
                    //Collections.shuffle(player1Hand);
                    //Collections.shuffle(player2Hand);
                    System.out.println("Player One is the Winner!");
                } else if (player2Hand.get(0) > player1Hand.get(0)) {
                    int i = player1Hand.get(0);
                    int j = player2Hand.get(0);
                    player1Hand.remove(0);
                    player2Hand.remove(0);
                    player2Hand.add(i);
                    player2Hand.add(j);
                    //Collections.shuffle(player1Hand);
                    //Collections.shuffle(player2Hand);
                    System.out.println("Player Two is the Winner!");
                } else if (player1Hand.get(0) == player2Hand.get(0)) {
                     System.out.println("The cards were equal in value, time for a war!");
                     if(player1Hand.size() < 4){
                         System.out.println("Player 1 did not have enough cards to enter the war. As such, player 2 wins the game!");
                         System.exit(0);
                     }
                      if(player2Hand.size() < 4){
                         System.out.println("Player 2 did not have enough cards to enter the war. As such, player 1 wins the game!");
                         System.exit(0);
                     }
                    if (player1Hand.get(3) > player2Hand.get(3)) {
                        int i = player1Hand.get(0);
                        int j = player2Hand.get(0);
                        int k = player1Hand.get(1);
                        int l = player2Hand.get(1);
                        int m = player1Hand.get(2);
                        int n = player2Hand.get(2);
                        int o = player1Hand.get(3);
                        int p = player2Hand.get(3);
                        player1Hand.remove(0);
                        player2Hand.remove(0);
                        player1Hand.remove(1);
                        player2Hand.remove(1);
                        player1Hand.remove(2);
                        player2Hand.remove(2);
                        player1Hand.remove(3);
                        player2Hand.remove(3);
                        player1Hand.add(i);
                        player1Hand.add(j);
                        player1Hand.add(k);
                        player1Hand.add(l);
                        player1Hand.add(m);
                        player1Hand.add(n);
                        player1Hand.add(o);
                        player1Hand.add(p);
                        //Collections.shuffle(player1Hand);
                        //Collections.shuffle(player2Hand);
                        System.out.println("Player One is the Winner!");
                    } else if (player2Hand.get(3) > player1Hand.get(3)) {
                        int i = player1Hand.get(0);
                        int j = player2Hand.get(0);
                        int k = player1Hand.get(1);
                        int l = player2Hand.get(1);
                        int m = player1Hand.get(2);
                        int n = player2Hand.get(2);
                        int o = player1Hand.get(3);
                        int p = player2Hand.get(3);
                        player1Hand.remove(0);
                        player2Hand.remove(0);
                        player1Hand.remove(1);
                        player2Hand.remove(1);
                        player1Hand.remove(2);
                        player2Hand.remove(2);
                        player1Hand.remove(3);
                        player2Hand.remove(3);
                        player2Hand.add(i);
                        player2Hand.add(j);
                        player2Hand.add(k);
                        player2Hand.add(l);
                        player2Hand.add(m);
                        player2Hand.add(n);
                        player2Hand.add(o);
                        player2Hand.add(p);
                        //Collections.shuffle(player1Hand);
                        //Collections.shuffle(player2Hand);
                        System.out.println("Player Two is the Winner!");
                    } else if (player1Hand.get(3) == player2Hand.get(3)) {
                        Collections.shuffle(player1Hand);
                        Collections.shuffle(player2Hand);
                        System.out.println("The War ended in a draw, as such both player hands have been shuffled and no cards have been exchanged");
                    }
                }

                //if statement for the end of the game
                if (player1Hand.isEmpty()) {
                    System.out.println("The game is over! Player 2 Wins!");
                }
                if (player2Hand.isEmpty()) {
                    System.out.println("The game is over! Player 1 Wins!");
                }
            }
                cardNum1 = player1Hand.size();
                cardNum2 = player2Hand.size();
        }
    }
}
