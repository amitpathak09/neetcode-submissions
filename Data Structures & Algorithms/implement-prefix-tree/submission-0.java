class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endsHere;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();         
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++) {
            if(curr.children[word.charAt(i)-'a']==null) {
                curr.children[word.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[word.charAt(i)-'a'];
            } else {
                curr = curr.children[word.charAt(i)-'a'];
            }
        }
        curr.endsHere = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++) {
            if(curr.children[word.charAt(i)-'a']!=null) {
                curr=curr.children[word.charAt(i)-'a'];
            } else {
                return false;
            }
        }
        if(curr.endsHere) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i=0; i<prefix.length(); i++) {
            if(curr.children[prefix.charAt(i)-'a']!=null) {
                curr=curr.children[prefix.charAt(i)-'a'];
            } else {
                return false;
            }
        }
        return true;

    }
}
