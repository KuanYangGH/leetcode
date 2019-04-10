package medium.question207;


import java.util.HashSet;
import java.util.Set;

/**
 * Course Schedule
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * 将边转化为邻接矩阵，然后进行拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        int[][] adjacencyMatrices = convertToAdjacencyMatrices(numCourses, prerequisites,inDegrees);

        Set<Integer> courses = new HashSet<>();
        while (courses.size()<numCourses){
            int i = findIn0DegreeCourse(inDegrees,courses);
            if(i==-1) return false;
            courses.add(i);
            removeEdges(adjacencyMatrices,i,inDegrees);
        }
        return true;
    }

    private int[][] convertToAdjacencyMatrices(int numCourses, int[][] prerequisites,int[] inDegrees) {
        int[][] adjacencyMatrices = new int[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adjacencyMatrices[prerequisites[i][0]][prerequisites[i][1]] = 1;
            inDegrees[prerequisites[i][0]]++;
        }
        return adjacencyMatrices;
    }
    private int findIn0DegreeCourse(int[] inDegrees,Set<Integer> courses){
        for (int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0&&!courses.contains(i)){
                return i;
            }
        }
        return -1;
    }
    private void removeEdges(int[][] adjacencyMatrices,int j,int[] inDegrees){
        for(int i=0;i<adjacencyMatrices.length;i++){
            if(adjacencyMatrices[i][j]==1){
                adjacencyMatrices[i][j]=0;
                inDegrees[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(new Solution().canFinish(numCourses,prerequisites));
    }
}

