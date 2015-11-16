package bp;

import java.util.Comparator;

public class WeightComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex o1, Vertex o2) {
		if (o1.getDistance() < o2.getDistance()) {
			return -1;
		}
		if (o1.getDistance() > o2.getDistance()) {
			return 1;
		}
		return 0;
	}


}
