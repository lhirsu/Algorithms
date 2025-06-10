package problems.interview;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule test = new CourseSchedule();

        List<List<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(Arrays.asList(0, 1));
        prerequisites.add(Arrays.asList(1, 2));
        prerequisites.add(Arrays.asList(2, 3));
        prerequisites.add(Arrays.asList(3, 4));
        prerequisites.add(Arrays.asList(4, 5));
        System.out.println(test.canFinish(6, prerequisites));           // should return true

        List<List<Integer>> prerequisitesWithCycle = new ArrayList<>();
        prerequisitesWithCycle.add(Arrays.asList(0, 1));
        prerequisitesWithCycle.add(Arrays.asList(1, 2));
        prerequisitesWithCycle.add(Arrays.asList(2, 0));
        System.out.println(test.canFinish(3, prerequisitesWithCycle));  // should return false
    }

    public boolean canFinish(int numCourses, List<List<Integer>> prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph and indegree array
        for (List<Integer> prerequisitePair : prerequisites) {
            graph.get(prerequisitePair.get(1)).add(prerequisitePair.get(0));
            indegree[prerequisitePair.get(0)]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // add all courses with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        List<Integer> courseSchedule = new ArrayList<>();

        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseSchedule.add(course);
            processed++;
            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) { // means it has no prerequisite
                    queue.offer(neighbor);
                }
            }
        }

        return processed == numCourses;
    }

}