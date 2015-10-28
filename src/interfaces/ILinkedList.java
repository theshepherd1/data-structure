package interfaces;

import bp.Data;
import bp.Link;

public interface ILinkedList {

	boolean isEmpty();

	void clear();

	int getSize();

	Link getFirst();

	void setFirst(Link pFirst);

	Link getLast();

	void setLast(Link pLast);

	void insertLeft(Link linkToInsert);

	void insertLeft(Data dataToInsert);

	void insertRight(Link linkToInsert);

	void insertRight(Data dataToInsert);

	Data removeLeft();
	
	Data removeRight();
}