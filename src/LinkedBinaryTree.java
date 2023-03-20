import java.util.Iterator;

public class LinkedBinaryTree<T> implements IBinaryTree<T> {
    private static class Node<T> implements IPosition<T> {
        private T element;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        @Override
        public T elemet() {
            return element;
        }

        public void setElement(T elem) {
            element = elem;
        }

        public void setParent(Node<T> p) {
            parent = p;
        }

        public void setLeft(Node<T> l) {
            left = l;
        }

        public void setRight(Node<T> r) {
            right = r;
        }
    }

    private Node<T> root = null;
    private int size = 0;

    /**
     * Construct an empty tree.
     */
    public LinkedBinaryTree() {
    }

    /**
     * Cast IPosition to Node
     */
    private Node<T> validate(IPosition<T> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid Position Type");
        }
        return (Node<T>) p;
    }

    private Node<T> createNode(T e, Node<T> p, Node<T> l, Node<T> r) {
        return new Node<>(e, p, l, r);
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position
     */
    public IPosition<T> addRoot(T e) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not Empty!");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public IPosition<T> addLeft(IPosition<T> p, T e) {
        Node<T> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child!");
        Node<T> leftChild = new Node<>(e, null, null, null);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public IPosition<T> addRight(IPosition<T> p, T e) {
        Node<T> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalArgumentException("p already has a right child!");
        Node<T> rightChild = new Node<>(e, null, null, null);
        parent.setRight(rightChild);
        size++;
        return rightChild;
    }

    /**
     * Replaces the element at Position p with e and returns the replaced element
     */
    public T set(IPosition<T> p, T e) {
        Node<T> node = validate(p);
        T temp = node.elemet();
        node.setElement(e);
        return temp;
    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     */
    public void attach(IPosition<T> p, LinkedBinaryTree<T> t1, LinkedBinaryTree<T> t2) {
        Node<T> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            // Doubly Linked List
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child,
     */
    public T remove(IPosition<T> p) {
        Node<T> node = validate(p);
        if (numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
        Node<T> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(node.getParent());
        }
        // doubly linked list
        if (node == root) {
            root = child;
        } else {
            Node<T> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        // free the memory
        T temp = node.elemet();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }

    @Override
    public IPosition<T> left(IPosition<T> p) {
        return validate(p).getLeft();
    }

    @Override
    public IPosition<T> right(IPosition<T> p) {
        return validate(p).getRight();
    }

    @Override
    public IPosition<T> root() {
        return root;
    }

    @Override
    public IPosition<T> parent(IPosition<T> p) {
        return validate(p).getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterable<IPosition<T>> positions() {
        return null;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<>();
    }
}
