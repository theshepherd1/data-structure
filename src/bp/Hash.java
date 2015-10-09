package bp;

public class Hash {
	
	public static String hash(String s) {
		int h = 0;
		char val[] = s.toCharArray();
		int len = s.length();
 
		for (int i = 0; i < len; i++) {
			//additive hash
			h += val[i];
			
			//XOR hash
		    h ^= val[i];
		    
			//Rotating hash
		    h = (h << 4) ^ (h >> 21) ^ val[i];
		    h = (h << 6) ^ (h >> 12) ^ val[i];
		    h = (h << 21) ^ (h >> 8) ^ val[i];

		    //Bernstein hash
		    h = 33 * h ^ val[i];

		    //shift-add-XOR hash
	        h ^= (h << 5) + (h >> 2) + val[i];
		}
		return Integer.toUnsignedString(h);
	}
	
}
