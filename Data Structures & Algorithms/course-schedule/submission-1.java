class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //seems like we've to detect cycle in the graph

        //who all depends on this course
        Map<Integer, List<Integer>> depMap = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite: prerequisites) {
            List<Integer> tempList = depMap.getOrDefault(prerequisite[1], new ArrayList<>());
            tempList.add(prerequisite[0]);
            depMap.put(prerequisite[1],tempList);
            indegree[prerequisite[0]]++;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                stack.push(i);
            }
        }

        int finished = 0;
        while(stack.size()!=0) {
            int curr = stack.pop();
            finished++;
            for(Integer course: depMap.getOrDefault(curr, new ArrayList<>())) {
                indegree[course]--;
                if(indegree[course]==0) {
                    stack.push(course);
                }
            }
        }

        if(finished == numCourses) {
            return true;
        }
        return false;
    }
}
