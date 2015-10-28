package interfaces;

import java.time.LocalDate;

public interface IHeap {

	boolean isEmpty();

	int getSize();

	void clear();

	void insert(LocalDate valueToInsert);

	void delete(LocalDate valueToDelete);

	String toString();
}
