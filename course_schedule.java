// Use BFS to check if given schedule is feasable
// TC: O(n) : going over each course in the queue just once unless there's circular dependency
// SC: O(n) : queue size is O(n) at the maximum, inDegree is O(n) and map is also O(n) - in total - O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courses = new HashMap<>();

        int len = prerequisites.length;
        int[] inDegree = new int[numCourses];
        int completedCourses = 0;

        for(int i=0;i<numCourses;i++){
            courses.put(i, new ArrayList<>());
        }

        for(int i=0;i<len;i++){
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        if(queue.size() == 0){
            return false;
        }

        while(queue.size()>0){
            int currCourse = queue.remove();
            completedCourses++;
            for(int i: courses.get(currCourse)){
                inDegree[i]--;
                if(inDegree[i] == 0) { queue.add(i);}
            }
        }
        return completedCourses == numCourses;
    }
}
