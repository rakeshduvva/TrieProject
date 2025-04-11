
import java.util.Scanner;

class Trie {
    private Trie[] children;
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    private static Trie root = new Trie();

    public static void main(String[] args) {
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Get all words");
        System.out.println("4. Get all words with prefix");

        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int choice;
        do {
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the word to insert: ");
                    String wordToInsert = sc.nextLine();
                    trie.insert(wordToInsert);
                    break;
                case 2:
                    System.out.println("Enter the word to search: ");
                    String wordToSearch = sc.nextLine();
                    if(trie.doesExist(root, wordToSearch)) {
                        System.out.println("Word exists in the Trie.");
                    } else {
                        System.out.println("Word does not exist in the Trie.");
                    }
                    break;
                case 3:
                    System.out.println("All words in the Trie: ");
                    break;
                case 4:
                    System.out.println("Enter the prefix to search: ");
                    break;
            }
        } while (choice != 0);
    }

    void insert(String s) {
        Trie current = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    boolean doesExist(Trie root, String s) {
        Trie current = root;
        for(char ch:s.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
}