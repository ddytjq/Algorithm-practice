import java.util.*;
import java.io.*;

public class Practice_15 {
	Scanner sc = new Scanner(System.in);
	int T;
	int N,M;
	int[][] W;
	boolean[] check;
	int size=0;
	LinkedList[] link;
	public Practice_15(){
		T = sc.nextInt();
		for(int TT=0 ; TT<T;TT++)
		{
			N = sc.nextInt(); M = sc.nextInt();
			W = new int[N][N];
			link = new LinkedList[N];
			size=0;
			for(int i=0;i<N;i++){
				link[i] = new LinkedList<Integer>();
			}
			check = new boolean[N];
			for(int i=0;i<M;i++)
			{
				int s = sc.nextInt()-1;
				int e = sc.nextInt()-1;
				W[s][e] = sc.nextInt();
				W[e][s] = W[s][e];
				link[s].add(e);
				link[e].add(s);
			}
			for(int i=0;i<N;i++){
				dijkstra(i);
			}
			System.out.println("Case #"+(TT+1));
			System.out.print(N-size+" ");
			for(int i=0;i<N;i++){
				if(!check[i]){
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
			
		}
	}
	public void dijkstra(int index){
		int[] distance = new int[N];
		int[] nearest = new int[N];
		boolean[] visit = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue();
		for(int i=0;i<N;i++){
			nearest[i] = -1;
		}
		for(int i=0;i<link[index].size();i++){
			int near = (int)link[index].get(i);
			distance[near] = W[index][near];
			nearest[near] = index;
			pq.add(new Edge(index,near,W[index][near]));
		}
		int count=1;
		visit[index] = true;
		while(!pq.isEmpty()){
			Edge next = pq.poll();
			if(visit[next.s]&&visit[next.e]){
				continue;
			}
			visit[next.e] =true;
			nearest[next.e] = next.s;
			count++;
			for(int i=0;i<link[next.e].size();i++){
				int near = (int)link[next.e].get(i);
				if(!visit[near])
					pq.add(new Edge(next.e,near,next.w+W[next.e][near]));
			}
		}
		for(int i=0;i<N;i++){
			if(nearest[i]!=index&&nearest[i]!=-1&&nearest[i]!=i)
			{
				if(!check[nearest[i]]){
					size++;
				}
				check[nearest[i]]=true;
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Practice_15();
	}
	public class Edge implements Comparable<Edge>{
		int s,e,w;
		public Edge(int s,int e, int w){
			this.s =s;
			this.e =e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge arg0) {
			// TODO Auto-generated method stub
			return w>arg0.w ? 1 : -1;
		}
		
	}

}