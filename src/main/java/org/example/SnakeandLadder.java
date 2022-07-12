package org.example;

import java.util.*;

public class SnakeandLadder
{
    public static void main(String[] args) {
        List<String> propsBoard = new ArrayList<>();
        propsBoard.add("SNAKE");
        propsBoard.add("LADDER");
        propsBoard.add("NOPLAY");
        System.out.println("------ SNAKE AND LADDER GAME ------");
        Random random = new Random();
        int position = 0;
        while (true)
        {
            String checkBoard = propsBoard.get(random.nextInt(propsBoard.size()));
            int random_int = (int) Math.floor(Math.random() * 6) + 1;
            if (checkBoard.equals("SNAKE"))
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
            }
            else if (checkBoard.equals("LADDER"))
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

            }
            else
            {
                System.out.println("Dice Roll " + random_int);

                if(position > 100)
                {
                    System.out.println("No Play");
                    System.out.println("Retry");
                }
                else
                {
                    System.out.println("No Play , Position"+ position);

                }
            }
            if(position == 100)
            {
                System.out.println("------ END OF GAME ------");
                break;
            }
        }

    }
}
