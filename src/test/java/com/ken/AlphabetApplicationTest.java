package com.ken;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the alphabet application.
 */
public class AlphabetApplicationTest {

    private AlphabetApplication alphabetApplication;

    /**
     * Setup of the test.
     */
    @Before
    public void setup() {
        alphabetApplication = new AlphabetApplication();
    }

    /**
     * Derives the order of the alphabet with null word list.
     *
     * Expects the result to be empty.
     */
    @Test
    public void test_deriveAlphabetOrder_withNullWordList() {
        char[] result = alphabetApplication.deriveAlphabetOrder(null);
        Assert.assertEquals(0, result.length);
    }

    /**
     * Derives the order of the alphabet with an empty word list.
     *
     * Expects the result to be empty.
     */
    @Test
    public void test_deriveAlphabetOrder_withEmptyWordList() {
        String[] words = new String[0];

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(0, result.length);
    }

    /**
     * Derives the order of the alphabet with one letter word.
     *
     * Expects the result to be the one letter word.
     */
    @Test
    public void test_deriveAlphabetOrder_withOneLetterWord() {
        String[] words = new String[1];
        words[0] = "b";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(1, result.length);
        Assert.assertEquals('b', result[0]);
    }

    /**
     * Derives the order of the alphabet with one letter word list.
     *
     * Expects the result to be the order of the words provided.
     */
    @Test
    public void test_deriveAlphabetOrder_withOneLetterWordList() {
        String[] words = new String[3];
        words[0] = "b";
        words[1] = "a";
        words[2] = "c";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals('b', result[0]);
        Assert.assertEquals('a', result[1]);
        Assert.assertEquals('c', result[2]);
    }

    /**
     * Derives the order of the alphabet with words of the same length.
     *
     * Expects alphabet order to be b,a,c.
     */
    @Test
    public void test_deriveAlphabetOrder_withWordsOfTheSameLength() {
        String[] words = new String[3];
        words[0] = "bca";
        words[1] = "aaa";
        words[2] = "acb";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals('b', result[0]);
        Assert.assertEquals('a', result[1]);
        Assert.assertEquals('c', result[2]);
    }

    /**
     * Derives the order of the alphabet with words of different length.
     *
     * Expects alphabet order to be b,a,c.
     */
    @Test
    public void test_deriveAlphabetOrder_withWordsOfDifferentLength() {
        String[] words = new String[4];
        words[0] = "b";
        words[1] = "ba";
        words[2] = "aac";
        words[3] = "acc";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals('b', result[0]);
        Assert.assertEquals('a', result[1]);
        Assert.assertEquals('c', result[2]);
    }

    /**
     * Derives the order of the alphabet with all words starting with the same
     * letter.
     *
     * Expects alphabet order to be b,a,c.
     */
    @Test
    public void test_deriveAlphabetOrder_withLettersStartingWithSameCharacter() {
        String[] words = new String[3];
        words[0] = "bbb";
        words[1] = "bac";
        words[2] = "bca";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals('b', result[0]);
        Assert.assertEquals('a', result[1]);
        Assert.assertEquals('c', result[2]);
    }

    /**
     * Derives the order of the alphabet with all words starting with the same
     * letter.
     *
     * Expects alphabet order to be b,a,c.
     */
    @Test
    public void test_deriveAlphabetOrder_withDuplicateWords() {
        String[] words = new String[6];
        words[0] = "bbb";
        words[1] = "bbb";
        words[2] = "bac";
        words[3] = "bac";
        words[4] = "bca";
        words[5] = "bca";

        char[] result = alphabetApplication.deriveAlphabetOrder(words);
        Assert.assertEquals(3, result.length);
        Assert.assertEquals('b', result[0]);
        Assert.assertEquals('a', result[1]);
        Assert.assertEquals('c', result[2]);
    }
}
