public class HelloWorld{

	public static void main(String[] args) {
		int[] array = {6,5,4,3,2,1};
		int[] sorted = mergeSort(array);
		
		for (int i : sorted) {
			System.out.print(i);
		}
	}
	
	public static int[] mergeSort(int[] array) {
		int[] helper = new int[array.length];
		return mergeSort(array, helper, 0, array.length-1);
	}
	
	public static int[] mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low+high)/2;
			mergeSort(array, helper, low, mid);
			mergeSort(array, helper, mid+1, high);
			merge(array, helper, low, mid, high);
		}
		return array;
	}
	
	public static void merge(int[] array, int[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = left;
		int helperRight = mid+1;
		int current = left;
		
		while (helperLeft <= mid && helperRight <= right) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current+i] = helper[helperLeft+i];
        }
	}
}
