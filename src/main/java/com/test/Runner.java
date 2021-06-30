package com.test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {

    int shelfSize = 150;
    int boardGamesSize = 0;
    int boardGameCounter = 1;
    HashSet<BoardGame> boardGames = new HashSet<>();
    int width = 0;
    int height = 0;
    int depth = 0;
    String name = "";
    String colour = "";
    BigDecimal price = new BigDecimal("00.00");
    BoardGame boardGame;

    Scanner scan = new Scanner(System.in);
    try {
      System.out.print("What's the price of every game? ");
      String priceToConvert = scan.nextLine();
      priceToConvert = priceToConvert.replaceAll(",",".");
      price=new BigDecimal(priceToConvert);
    } catch (NumberFormatException ex) {
      System.out.println("Not a number!");
      System.exit(0);
    }
    do {
      try {

        System.out.println("Enter " + boardGameCounter + " board game:");
        System.out.print("Enter width(integer in cm): ");

        width = scan.nextInt();

        System.out.print("Enter height(integer in cm): ");
        height = scan.nextInt();
        System.out.print("Enter depth(integer in cm): ");
        depth = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter name(text, cannot be the same as added): ");
        name = scan.nextLine();
        System.out.print("Enter colour(text): ");
        colour = scan.nextLine();
        System.out.println("Price is(decimal number): " + price);

        boardGame =
                new BoardGame(
                        boardGameCounter, new Dimension(width, height, depth), name, colour, price);




        //System.out.println("bg hashCode " + boardGame.hashCode());
        BoardGame finalBoardGame = boardGame;
        long sameElementsCounter =
            boardGames.stream().filter(b -> b.getName().equals(finalBoardGame.getName())).count();

        if (sameElementsCounter != 0) {
          System.out.println("Such a game already exists! Add another one");
          //boardGameCounter--;
        } else {
          boardGames.add(boardGame);
          boardGameCounter++;
          boardGamesSize = boardGamesSize + width;
        }

        System.out.println(boardGames);
        System.out.println("Quit? press q. If not press any other key");
        String q = scan.next();
        if (q.equalsIgnoreCase("q")) System.exit(0);
        else {
          continue;
        }

      } catch (InputMismatchException e) {
        System.out.println("Wrong format!");
      }
    } while (boardGamesSize < shelfSize);

    while (boardGamesSize > shelfSize) {
      System.out.println("The games do not fit in the shelf");
      System.out.print("Which game do you want to take off? Give number of game: ");
      int numberOfGame = scan.nextInt();
      BoardGame bg =
          boardGames.stream()
              .filter(c -> c.getNumberOfGame() == numberOfGame)
              .findFirst()
              .orElse(null);
      boardGames.remove(bg);
      boardGamesSize = boardGamesSize - bg.getDimension().getWidth();
      System.out.println(boardGames);

      if (boardGamesSize < shelfSize) {}
    }
  }
}
