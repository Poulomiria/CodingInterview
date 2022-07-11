package Tree;

public class Traversal {
	public static void preTraverse(Node root) {

		if (root == null) return;

		System.out.print(root.getData() + ",");
	preTraverse(root.getLeftChild());
	preTraverse(root.getRightChild());

	}
	
	public static void inTraverse(Node root) {

		if (root == null) return;

		inTraverse(root.getLeftChild());
		System.out.print(root.getData() + ",");
		inTraverse(root.getRightChild());

	}
	
	public static void postTraverse(Node root) {

		if (root == null) return;

		postTraverse(root.getLeftChild());
		postTraverse(root.getRightChild());
		System.out.print(root.getData() + ",");

	}

}
