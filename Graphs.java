import java.util.*;
public class Graphs {
    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v,int direction){
        graph.get(u).add(v);
        if(direction==1){
            graph.get(v).add(u);
        }
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> graph){
        System.out.println(graph);
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph ,int n){
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int ele = q.remove();
            System.out.print(ele+" ");
            for(int i=0;i<graph.get(ele).size();i++){
                if(!visited[graph.get(ele).get(i)]){
                    q.add(graph.get(ele).get(i));
                    visited[graph.get(ele).get(i)]=true;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n=sc.nextInt();
        int e=sc.nextInt();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            addEdge(graph,u,v,1);
        }
        bfs(graph,n);
    }
}
