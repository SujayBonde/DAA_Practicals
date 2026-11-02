
import heapq
from collections import Counter

# Node class
class Node:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None


# Build Huffman Tree
def build_huffman_tree(text):

    freq = Counter(text)
    heap = []

    for char, frequency in freq.items():
        node = Node(char, frequency)

        heapq.heappush(
            heap, (frequency, id(node), node)
        )

    while len(heap) > 1:

        freq1, _, left = heapq.heappop(heap)
        freq2, _, right = heapq.heappop(heap)

        parent = Node(None, freq1 + freq2)

        parent.left = left
        parent.right = right

        heapq.heappush(
            heap, (parent.freq, id(parent), parent)
        )

    return heap[0][2]


# Generate Huffman Codes
def generate_codes(root, code="", codes=None):

    if codes is None:
        codes = {}

    if root is None:
        return codes

    if root.char is not None:
        codes[root.char] = code if code else "0"
        return codes

    generate_codes(root.left, code + "0", codes)
    generate_codes(root.right, code + "1", codes)

    return codes



# Main program
text = input("Enter a Text: ")

root = build_huffman_tree(text)

codes = generate_codes(root)

for data, code in codes.items():
    print(f"{data} : {code}")