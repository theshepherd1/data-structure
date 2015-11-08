package interfaces;

import java.time.LocalDate;

import bp.Node;

public interface IBinaryTree {
	LocalDate showMinimumValue();

	LocalDate showMaximumValue();

	boolean isEmpty();

	int getSize();

	void clear();

	void insert(LocalDate valueToInsert);

	void delete(LocalDate valueToDelete);

	Node find(LocalDate valueToFind);

	String toString();
}
