package interfaces;

import java.time.LocalDate;

import bp.Node;

public interface IBinaryTreeNode {

	public abstract LocalDate getDate();

	public abstract void setDate(LocalDate pDate);

	public abstract Node getLeftChild();

	public abstract void setLeftChild(Node pLeftChild);

	public abstract Node getRightChild();

	public abstract void setRightChild(Node pRightChild);

}