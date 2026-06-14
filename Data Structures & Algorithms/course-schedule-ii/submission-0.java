class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();

        Map<Integer,List<Integer>> depMap = new HashMap<>();
        int[] dependsOn = new int[numCourses];

        for(int[] p: prerequisites) {
            List<Integer> depList = depMap.getOrDefault(p[1], new ArrayList<>());
            depList.add(p[0]);
            depMap.put(p[1],depList);
            dependsOn[p[0]]++;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(dependsOn[i]==0) {
                stack.push(i);
            }
        }


        while(stack.size()!=0) {
            int curr = stack.pop();
            res.add(curr);
            for(Integer course: depMap.getOrDefault(curr, new ArrayList<>())) {
                dependsOn[course]--;
                if(dependsOn[course]==0) {
                    stack.push(course);
                }
            }

        }

        if(res.size()!=numCourses) {
            return new int[0];
        }

        int[] out = new int[res.size()];
        for(int k=0; k<res.size(); k++) {
            out[k]=res.get(k);
        }
        return out;
    }
}
