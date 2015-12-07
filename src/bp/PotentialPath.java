package bp;

import java.util.ArrayList;
import bp.Index;
import java.util.List;

public class PotentialPath implements Comparable {
	private static int instancesCreated = 0;
	private List<Integer> potentialPath = new ArrayList<>();
	private int fCost;
	private int hCost;

	
	//I believe that you should use hCost to order the paths
	@Override
	public int compareTo(Object pO) {
		if (hCost < ((PotentialPath) pO).hCost) {
			return -1;
		} else if (hCost > ((PotentialPath) pO).hCost) {
			return 1;
		} else {
			return 0;
		}
	}

	public PotentialPath(List<Integer> pPotentialPath, int pFCost) {
		potentialPath = pPotentialPath;
		fCost = pFCost;
		instancesCreated++;
	}
	
	public PotentialPath(List<Integer> pPotentialPath, int pFCost, int pHCost) {
		potentialPath = pPotentialPath;
		fCost = pFCost;
		hCost = pHCost;
		instancesCreated++;
	}
	
	public List<Integer> getPotentialPath() {
		return potentialPath;
	}

	public static int getInstancesCreated() {
		return instancesCreated;
	}
	
	public List<Integer> getPotentialPathCopy() {
		List<Integer> copy = new ArrayList<>();
		for (Integer i : potentialPath) {
			copy.add(i);
		}
		return copy;
	}
}
