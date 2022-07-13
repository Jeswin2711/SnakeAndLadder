package org.example;

import java.util.*;

public class SnakeAndLadder
{


    public static int againCheckBoard (int player_one_position,int  another_chance, String againCheck)
    {
        if(againCheck == "LADDER")
        {
            player_one_position = ladder(player_one_position,another_chance);
        }
        else if (againCheck == "SNAKE")
        {
            player_one_position = snake(player_one_position,another_chance);
        }
        else
        {
            player_one_position = noPlay(player_one_position);
        }
        return player_one_position;
    }
    public static int noPlay(int position)
    {
        if(position > 100)
        {
            System.out.println("No Play");
            System.out.println("Retry");
        }
        else
        {
            System.out.println("No Play , Position " + position);
        }
        return position;
    }
    public static int ladder(int position , int random_int)
    {
        int temp = position + random_int;
        if (temp <= 100) {
            position += random_int;
            System.out.println("Dice Roll " + random_int);
            if (position > 100) {
                System.out.println("Ladder");
                System.out.println("Retry");
            } else {
                System.out.println("It's A Ladder");
                System.out.println("Moving to Position " + position);
            }
        }
        return position;
    }
    public static int snake(int position , int random_int)
    {
        if (random_int > position)
        {
            position = 0;
        }
        else
        {
            position -= random_int;
        }
        System.out.println("Dice Roll " + random_int);
        if(position > 100)
        {
            System.out.println("Snake");
            System.out.println("Retry");
        }
        else
        {
            if (position >= 100)
            {
                System.out.println("Well Done!");
            }
            else {
                System.out.println("It's A Snake ");
                System.out.println("Moving to Position " + position);
            }
        }
        return position;
    }

    public static void main(String[] args) {
        List<String> propsBoard = new ArrayList<>();
        propsBoard.add("SNAKE");
        propsBoard.add("LADDER");
        propsBoard.add("NOPLAY");
        List<String> playerName = new ArrayList<>();
        System.out.println("------ SNAKE AND LADDER GAME ------");
        Random random = new Random();
        int position = 0;
        int player_one_position = 0;
        int player_two_position = 0;
        String playerNo = "";
        System.out.println("Who Wants to Play the Game Press 1 For Player 1 and Press 2 For Player 2");
        Scanner scanner = new Scanner(System.in);
        String player = scanner.next();
        playerNo = "Player"+player;
        System.out.println(playerNo);
        while (true)
        {
            String checkBoard = propsBoard.get(random.nextInt(propsBoard.size()));
            int random_int = (int) Math.floor(Math.random() * 6) + 1;
            if (checkBoard.equals("SNAKE"))
            {
                if(playerNo.equals("Player1")) {
                    System.out.println("---- Player One Turn ----");
                    player_one_position = snake(player_one_position,random_int);
                    System.out.println("Player One Position " + player_one_position);
                    playerNo = "Player2";
                }
                else
                {
                    System.out.println("---- Player Two Turn ----");
                    player_two_position = snake(player_two_position,random_int);
                    System.out.println("Player Two Position " + player_two_position);
                    playerNo = "Player1";
                }
            }
            else if (checkBoard.equals("LADDER"))
            {
                String againCheck = propsBoard.get(random.nextInt(propsBoard.size()));
                if(playerNo.equals("Player1"))
                {
                    System.out.println("---- Player One Turn ----");
                    player_one_position = ladder(player_one_position,random_int);
                    int another_chance = (int) Math.floor(Math.random() * 6) + 1;
                    player_one_position = againCheckBoard(player_one_position,another_chance,againCheck);
                    playerNo="Player2";
                    System.out.println("Player One Position " + player_one_position);
                }
                else {
                    System.out.println("---- Player Two Turn ----");
                    player_two_position = ladder(player_two_position, random_int);
                    int another_chance = (int) Math.floor(Math.random() * 6) + 1;
                    player_two_position = againCheckBoard(player_two_position,another_chance,againCheck);
                    playerNo="Player1";
                    System.out.println("Player Two Position " + player_two_position);

                }
            }
            else {
                if(playerNo.equals("Player1"))
                {
                    System.out.println("---- Player One Turn ----");
                    System.out.println("Dice Roll " + random_int);
                    player_one_position = noPlay(player_one_position);
                    System.out.println("Player One Position " + player_one_position);
                    playerNo = "Player2";
                }
                else {
                    System.out.println("---- Player Two Turn ----");
                    System.out.println("Dice Roll " + random_int);
                    player_one_position = noPlay(player_one_position);
                    System.out.println("Player Two Position " + player_two_position);
                    playerNo = "Player2";
                }
            }
            if(player_one_position == 100)
            {
                System.out.println("PLayer One Won Congrats !!!");
                System.out.println("------ END OF GAME ------");
                break;
            }
            else if (player_two_position == 100)
            {
                System.out.println("Player Two Won Congrats !!!");
                System.out.println("------ END OF GAME ------");
                break;
            }
        }
    }
}
