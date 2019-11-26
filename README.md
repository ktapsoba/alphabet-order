# Alphabet Order

The alphabet order is a program that takes a list of words and return the order of the letters composing the word.

# Assumptions

- The list of words will have enough information to derive the complete order of the alphabet.
- The characters in the words are ASCII and are all lowercase
- List of words can contain duplicates

# Build

To build the program run the command `mvn clean install` at the root of the project.

# How to use

To use the alphabet order run the command `java -jar alphabet-order.jar` on the artifact created in the target folder.
The program will first ask for the number of words in the list, then it will ask for each words. After all the words are entered, the program will compute and print the order of the alphabet on the screen.

# Example

Let's run the program using a word list composed of 3 words. The words are "bca", "aaa", "acb".

```
java -jar alphabet-order.jar
Enter the number of words
3
Enter the list of words
bca
aaa
acb
The alphabet order is:
b,a,c
```
