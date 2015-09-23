package bp;

public class Data {

	private int value;
	private int priority;
	
	public Data(int pValue) {
		value = pValue;
	}
	
	public Data(int pValue, int pPriority) {
		value = pValue;
		priority = pPriority;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String toString() {
		return "[Value=" + value + " : Priority =" + priority + "]";
	}
}
