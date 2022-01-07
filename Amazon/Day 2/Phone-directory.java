Problem Link : https://practice.geeksforgeeks.org/problems/phone-directory4628/1/#

class Solution {
    static ArrayList < ArrayList < String >> displayContacts(int n,
        String contact[], String s) {
        Trie t = new Trie();

        for (int i = 0; i < n; ++i) {
            t.put(contact[i], i);
        }

        return t.keysWithPrefix(s, contact);
    }
    static class Trie {

        private class Node {
            int val = -1;
            Node[] next = new Node[Trie.this.R];
        }

        private Node root;
        private final int R = 256;

        public Trie() {
            this.root = new Node();
        }

        public void put(String key, int val) {
            root = put(root, key, val, 0);
        }

        private Node put(Node x, String key, int val, int d) {
            if (x == null) {
                x = new Node();
            }

            if (d == key.length()) {
                x.val = val;
            } else {
                int i = key.charAt(d);
                x.next[i] = put(x.next[i], key, val, d + 1);
            }

            return x;
        }

        public ArrayList < ArrayList < String >> keysWithPrefix(String str, String[] contact) {
            ArrayList < ArrayList < String >> list = new ArrayList < > ();

            int i, j;

            for (i = 0; i < str.length(); ++i) {
                list.add(new ArrayList < > ());
            }

            for (i = 0; i < str.length(); ++i) {
                Node x = get(root, str, 0, i + 1);

                if (x == null) {
                    break;
                } else {
                    collect(x, contact, list.get(i));
                }
            }

            while (i < str.length()) {
                list.get(i++).add("0");
            }

            return list;
        }

        private Node get(Node x, String key, int d, int length) {
            if (x == null || d == length) {
                return x;
            } else {
                int i = key.charAt(d);
                return get(x.next[i], key, d + 1, length);
            }
        }

        private void collect(Node x, String[] contact, ArrayList < String > list) {
            if (x == null) return;

            if (x.val >= 0) list.add(contact[x.val]);

            for (int i = 0; i < R; ++i) {
                collect(x.next[i], contact, list);
            }
        }

    }