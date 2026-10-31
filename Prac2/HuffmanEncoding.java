import java.util.PriorityQueue;

// Node of Huffman Tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class HuffmanEncoding {

    // Function to print Huffman codes
    static void printCodes(Node root, String code) {

        if (root == null) {
            return;
        }

        // If leaf node, print character and code
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " +
                    (code.isEmpty() ? "0" : code));
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        // Min Priority Queue
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) ->
                        Integer.compare(a.freq, b.freq));

        // Insert all characters into queue
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            // Remove two minimum frequency nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new internal node
            Node newNode = new Node(
                    '-',
                    left.freq + right.freq
            );

            newNode.left = left;
            newNode.right = right;

            // Insert new node into queue
            pq.add(newNode);
        }

        // Root of Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}
