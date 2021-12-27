package hw6;

public class Main {

    public static void main(String[] args) {

        int value;
        Tree theTree = new Tree();
        theTree.insert(new Number(10));
        theTree.insert(new Number(11));
        theTree.insert(new Number(9));
        theTree.insert(new Number(12));
        theTree.insert(new Number(8));
        theTree.insert(new Number(13));
        theTree.insert(new Number(7));

        Tree theTree2 = new Tree();
        theTree2.insert(new Number(10));
        theTree2.insert(new Number(11));
        theTree2.insert(new Number(9));
        theTree2.insert(new Number(12));
        theTree2.insert(new Number(8));
        theTree2.insert(new Number(13));
        theTree2.insert(new Number(20));

        theTree.displayTree();

        if ( theTree.countLeft() == theTree.countRight()){
            System.out.println("сбалансированное ");
        }else {
            System.out.println("несбалансированное ");
        }

        if ( theTree2.countLeft() == theTree2.countRight()){
            System.out.println("сбалансированное ");
        }else {
            System.out.println("несбалансированное ");
        }
    }

}

class Number {
    public int number;


    public Number() {

    }

    public Number(int number) {
        this.number = number;
    }
}

class Node {
    public Number number;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("number" + number.number);
    }

}

class Tree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.number.number != key) {
            if (key < current.number.number) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }


    public void insert(Number number) {
        Node node = new Node();
        node.number = number;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (number.number < current.number.number) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }


   // public boolean delete(int id) {
        // Тело метода
    //}

    public void displayTree() {
        Stack stack = new Stack(100);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack localStack = new Stack(100);
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (temp != null) {
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................");
        }
    }

    class Stack {
        private int maxSize;
        private Node[] stack;
        private int top;

        public Stack(int size) {
            this.maxSize = size;
            this.stack = new Node[this.maxSize];
            this.top = -1;
        }

        public void push(Node n) {
            this.stack[++this.top] = n;
        }

        public Node pop() {
            return this.stack[this.top--];
        }

        public Node peek() {
            return this.stack[this.top];
        }

        public boolean isEmpty() {
            return (this.top == -1);
        }

        public boolean isFull() {
            return (this.top == this.maxSize - 1);
        }
    }

    //
    public int countLeft() {

        int count = 0;
        Node current, last = null;
        current = root;
        while (current != null) {
            //  last = current;
            current = current.leftChild;
            count++;
        }

        return count;
    }

    public int countRight() {

        int count = 0;
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
            count++;
        }

        return count;
    }


}



