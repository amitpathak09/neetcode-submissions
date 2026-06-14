class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endsHere;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchString(word, curr);
    }

    private boolean searchString(String str, TrieNode root) {        
        if(str.isEmpty()) {
            return root.endsHere;
        }

        TrieNode curr = root;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='.') {
                for(TrieNode node: curr.children) {
                    if(node!=null) {
                        if(searchString(str.substring(i+1, str.length()), node)) {
                            return true;
                        }
                    }
                }
                return false;
            } else if(curr.children[str.charAt(i)-'a']!=null) {
                curr = curr.children[str.charAt(i)-'a'];
            } else {
                return false;
            }
        }

        if(curr.endsHere) {
            return true;
        }
        return false;
    }
}
