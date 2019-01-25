
/**
 * 
 * @author Matt Boutell and Cooper Anderson.
 */

public class BinaryTree {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinaryTree() {
		root = NULL_NODE;
	}

	/**
	 * Constructs a tree (any tree of characters, not just a BST) with the given
	 * values and number of children, given in a pre-order traversal order. See
	 * the HW spec for more details.
	 * 
	 * @param chars
	 *            One char per node.
	 * @param children
	 *            L,R, 2, or 0.
	 */
	public BinaryTree(String chars, String children) {
		if (chars.length() != 0) this.root = new BinaryNode(chars.charAt(0), chars, children, new IntWrapper());
		else this.root = NULL_NODE;
	}

	/**
	 * In-order traversal of the characters
	 */
	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * @return A string showing an in-order traversal of nodes with extra
	 *         brackets so that the structure of the tree can be determined.
	 */
	public String toStructuredString() {
		return root.toStructuredString();
	}

	public class IntWrapper {
		int index;
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public BinaryNode(Character element, String chars, String children, IntWrapper index) {
			this.data = element;
			char c = children.charAt(index.index);
			if (c == 'L' || c == '2' && index.index + 1 < children.length()) this.left = new BinaryNode(chars.charAt(++index.index), chars, children, index);
			else this.left = NULL_NODE;
			if (c == 'R' || c == '2' && index.index + 1 < children.length()) this.right = new BinaryNode(chars.charAt(++index.index), chars, children, index);
			else this.right = NULL_NODE;
		}

		public void construct(String chars, String children, IntWrapper index) {
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + data + right.toString();
		}

		public String toStructuredString() {
			if (this == NULL_NODE) {
				return "";
			}
			return "(" + left.toStructuredString() + this.data
					+ right.toStructuredString() + ")";
		}

	}
}