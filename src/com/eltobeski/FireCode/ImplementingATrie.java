package com.eltobeski.FireCode;

import java.util.HashMap;

public class ImplementingATrie {
    static class TrieNode {
        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(Character c) {
            this.c = c;
        }
    }

    static class Trie {
        private TrieNode root;

        // Implement these methods :
        public Trie() {
        }

        public void insertWord(String word) {
            if (word == null || word.isEmpty())
                return;
            if (root == null) {
                root = new TrieNode();
            }
            TrieNode node = root;
            HashMap<Character, TrieNode> childs = node.children;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                childs = node.children;
                if (node.children.containsKey(c)) {
                    node = childs.get(c);
                } else {
                    TrieNode newNode = new TrieNode(c);
                    childs.put(c, newNode);
                    node = newNode;

                }
                if (i == word.length() - 1) {
                    node.isLeaf = true;
                }

            }

        }

        public Boolean searchWord(String word) {
            if (word == null || word.isEmpty())
                return false;
            TrieNode node = root;
            HashMap<Character, TrieNode> childs;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                childs = node.children;
                if (childs.containsKey(c)) {
                    node = childs.get(c);
                    if (i == word.length() - 1 && node.isLeaf) {
                        return true;
                    }

                } else return false;
            }
            return false;
        }

        public Boolean searchPrefix(String word) {
            if (word == null || word.isEmpty())
                return false;
            TrieNode node = root;
            HashMap<Character, TrieNode> childs = node.children;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                childs = node.children;
                if (childs.containsKey(c)) {
                    if (i == word.length() - 1) {
                        return true;
                    }
                    node = childs.get(c);
                } else return false;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("FIRE");
        trie.insertWord("DADA");
        trie.insertWord("DADS");
        System.out.println(trie.searchPrefix("DAD"));
        System.out.println(trie.searchWord("FIRE"));
        System.out.println(trie.searchWord("DAD"));
    }
}
