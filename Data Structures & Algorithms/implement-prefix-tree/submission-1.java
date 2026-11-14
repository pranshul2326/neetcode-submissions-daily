class PrefixTree {
    class Node{
        Node[] child;
        boolean isEnd;
        Node(){
            child = new Node[26];
        }
    }
    Node  root;
    public PrefixTree() {
        root = new Node();
         
    }

    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];



        }
        curr.isEnd = true;

    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.child[ch - 'a'] == null){
                return false;
            }
            curr = curr.child[ch - 'a'];



        }
        return curr.isEnd;

    }

    public boolean startsWith(String word) {
                Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.child[ch - 'a'] == null){
                return false;
            }
            curr = curr.child[ch - 'a'];



        }
        return true;

    }
}
