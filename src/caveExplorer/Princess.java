package caveExplorer;

public class Princess extends NPC {

	
	public Princess() {
		
	}
	
	
	public String getSymbol() {
		return "S";
	}
	
	public int[] setCorner() {
		int rnd = (int)(Math.random()*4);
		int[][] corners = {{0,0},{0,CaveExplorer.caves[0].length-1},{CaveExplorer.caves.length-1,0},{CaveExplorer.caves.length-1,CaveExplorer.caves[0].length}};
		
		return corners[rnd];
	}
}
