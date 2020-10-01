package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {

    public static void main(String[] args) {
        String choice = wordchoice();

        char[] letters = explode(choice);

        char[] alphabet
                = {
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
                };

        System.out.print(
                " - - - -\n"
                + "|      |\t\t");
        System.out.print(alphabet);
        System.out.println(
                "\n|\n"
                + "|\n"
                + "|\n"
                + "|\n"
                + "|\n"
                + "\n");

        begin(letters, alphabet, choice);
    }

    public static String wordchoice() {
        int i = (int) (0 + Math.random() * 5);

        String[] words
                = {
                    "january", "march", "may", "july", "september"
                };

        return words[i];
    }

    public static char[] explode(String word) {
        char[] letters = word.toCharArray();
        return letters;
    }

    public static String begin(char[] letters, char[] alphabet, String choice) {
        int life = 6, i = 0;
        String word = choice;
        ArrayList<Character> usedletters = new ArrayList<Character>();
        Scanner input = new Scanner(System.in);

        while (i < word.length()) {
            if (letters[i] != 0) {
                letters[i] = '-';
            }
            i++;
        }

        System.out.println(letters);

        while (life > 0) {
            System.out.println("\nPlease guess a letter!");

            char guess = input.next().charAt(0);

            System.out.println("_____________________________________________");

            if (usedletters.contains(guess)) {
                System.out.println("\n" + guess + " already guessed!");
                diagram(life, letters, word, alphabet);
                continue;
            }

            for (int y = 0; y < alphabet.length; y++) {
                if (alphabet[y] == guess) {
                    alphabet[y] = '-';
                }
            }

            usedletters.add(guess);

            if (word.contains(guess + "")) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == guess) {
                        letters[j] = guess;
                    }
                }
            } else {
                life--;
            }

            if (word.equals(String.valueOf(letters))) {
                diagram(life, letters, word, alphabet);
                System.out.println("\nYou Win!");
                break;
            }
            diagram(life, letters, word, alphabet);
        }

        return null;
    }

    public static int diagram(int life, char[] letters, String word, char[] alphabet) {
        switch (life) {
            case 0:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|     /|\\\n"
                        + "|      |\n"
                        + "|     / \\\n"
                        + "|\n");
                System.out.println(letters);
                System.out.println("\nYou Lose!\n");
                System.out.println("Word: " + word + "\n");
                break;
            case 1:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|     /|\\\n"
                        + "|      |\n"
                        + "|     /\n"
                        + "|\n");
                System.out.println(letters);
                break;
            case 2:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|     /|\\\n"
                        + "|      |\n"
                        + "|\n"
                        + "|\n");
                System.out.println(letters);
                break;
            case 3:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|      |\\\n"
                        + "|      |\n"
                        + "|\n"
                        + "|\n");
                System.out.println(letters);
                break;
            case 4:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|      |\n"
                        + "|      |\n"
                        + "|\n"
                        + "|\n");
                System.out.println(letters);
                break;
            case 5:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      O\n"
                        + "|       \n"
                        + "|       \n"
                        + "|\n"
                        + "|\n");
                System.out.println(letters);
                break;
            case 6:
                System.out.print(
                        " - - - -\n"
                        + "|      |\t\t");
                System.out.print(alphabet);
                System.out.println(
                        "\n|      \n"
                        + "|      \n"
                        + "|      \n"
                        + "|\n"
                        + "|\n");
                System.out.println(letters);
        }
        return life;
    }

}
