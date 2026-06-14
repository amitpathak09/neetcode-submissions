class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        wordList.add(beginWord);
        Map<String, List<String>> connectionMap = new HashMap<>();
        for(int i=0; i<wordList.size(); i++) {
            List<String> connectionList = new ArrayList<>();
            for(int j=0; j<wordList.size(); j++) {
                if(i!=j && wordList.get(i).length()==wordList.get(j).length()) {
                    int diffCount = 0;
                    for(int k=0; k<wordList.get(i).length(); k++) {
                        if(wordList.get(i).charAt(k)!=wordList.get(j).charAt(k)) {
                            diffCount++;
                        }
                    }
                    if(diffCount==1) {
                        connectionList.add(wordList.get(j));
                    }
                } 
            }
            connectionMap.put(wordList.get(i),connectionList);
        }

        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int count=1;
        while(!queue.isEmpty()) {
            count+=1;
            int size = queue.size();
            for(int x=0; x<size; x++) {
                String curr = queue.poll();

                for(String con: connectionMap.get(curr)) {
                    if(con.equals(endWord)) {
                        return count;
                    }
                    if(!visited.contains(con)) {
                        visited.add(con);
                        queue.offer(con);
                    }
                }
            }

            
        }
        return 0;
    }
}
