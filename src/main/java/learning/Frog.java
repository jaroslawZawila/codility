package learning;

public class Frog {
	
	public int solution(int X, int Y, int D) {
		int distance = Y - X;
		int rest = distance % D;
		int hops = distance / D;
				
		if(rest > 0){
			return ++hops;
		}
		return hops;
	}
	
	public static void main(String[] arg) {
		System.out.println(new Frog().solution(10, 85, 30));
	}
}
