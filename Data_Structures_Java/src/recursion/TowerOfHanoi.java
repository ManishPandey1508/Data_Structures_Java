package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		
		
		towerOfHanoi(2, 'A','C', 'B');
		

	}

	 static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		 if(n==1) {
			 System.out.println("Move Disc From "+from_rod+" To  Rod "+to_rod);
			 return;
		 }
		 
		 towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
		
		System.out.println("Move Disc From "+ from_rod +" To Rod "+ to_rod);
		
		towerOfHanoi(n-1, from_rod, aux_rod, to_rod);  
		 
		 
	 }
	
}
