package com.ken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Alphabet Application that allows the user to derive the alphabet of the given
 * list of words
 */
public class AlphabetApplication {

    /**
     * Main method.
     *
     * @param args Application arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words");
        int numberOfWords = scanner.nextInt();
        String[] words = new String[numberOfWords];
        System.out.println("Enter the list of words");
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = scanner.next();
        }

        scanner.close();

        char[] alphabet = new AlphabetApplication().deriveAlphabetOrder(words);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The alphabet order is:\n");
        for (int i = 0; i < alphabet.length; i++) {
            if (i != 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(alphabet[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * Derives the order of the alphabet given the list of words.
     *
     * @param words the list of words
     *
     * @return the order of the alphabet
     */
    char[] deriveAlphabetOrder(final String[] words) {

        List<Character> alphabetOrder = new ArrayList<>();
        if (words == null || words.length == 0) {
            return new char[0];
        }

        if (words.length == 1 && words[0].length() == 1) {
            return new char[] { words[0].charAt(0) };
        }

        Map<Character, List<Character>> graph = new HashMap<>();
        char[] inDegreeCount = new char[26];
        for (int i = 1; i < words.length; i++) {
            String previous = words[i - 1];
            String current = words[i];
            for (int j = 0; j < previous.length() && j < current.length(); j++) {
                char prevChar = previous.charAt(j);
                char currChar = current.charAt(j);
                if (prevChar != currChar) {
                    List<Character> successors = graph.getOrDefault(prevChar, new ArrayList<>());
                    successors.add(currChar);
                    graph.put(prevChar, successors);

                    inDegreeCount[currChar - 'a']++;
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Character key : graph.keySet()) {
            if (inDegreeCount[key - 'a'] == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            alphabetOrder.add(c);
            for (char successor : graph.getOrDefault(c, new ArrayList<>())) {
                inDegreeCount[successor - 'a']--;
                if (inDegreeCount[successor - 'a'] == 0) {
                    queue.offer(successor);
                }
            }
        }

        char[] result = new char[alphabetOrder.size()];
        for (int i = 0; i < alphabetOrder.size(); i++) {
            result[i] = alphabetOrder.get(i);
        }

        return result;
    }
}
