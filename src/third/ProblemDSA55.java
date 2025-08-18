package third;
/*
MinHeap
*/

public class ProblemDSA55 {
    public static void main(String[] args) {
        SolutionDSA55 solution = new SolutionDSA55();

        SolutionDSA55.MinHeap h = new SolutionDSA55().new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.print(h.extractMin() + " ");
        System.out.print(h.getMin() + " ");

        h.decreaseKey(2, 1);
        System.out.print(h.getMin());
    }
}

class SolutionDSA55 {

    public class MinHeap {
        private int[] heapArray;
        private int capacity;
        private int currentHeapSize;

        public MinHeap(int n) {
            heapArray = new int[n];
            capacity = n;
            currentHeapSize = 0;
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        private int parent(int key) {
            return (key - 1) / 2;
        }

        private int leftChild(int key) {
            return 2 * key + 1;
        }

        private int rightChild(int key) {
            return 2 * key + 2;
        }

        public boolean insertKey(int key) {
            if (currentHeapSize == capacity) {
                return false;
            }

            int i = currentHeapSize;
            heapArray[currentHeapSize++] = key;

            while (i != 0 && heapArray[parent(i)] > heapArray[i]) {
                swap(heapArray, i, parent(i));
                i = parent(i);
            }

            return true;
        }

        public void decreaseKey(int key, int newVal) {
            heapArray[key] = newVal;

            while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
                swap(heapArray, key, parent(key));
                key = parent(key);
            }
        }

        public int getMin() {
            return heapArray[0];
        }

        public int extractMin() {
            if (currentHeapSize <= 0) {
                return Integer.MIN_VALUE;
            }

            if (currentHeapSize == 1) {
                currentHeapSize--;
                return heapArray[0];
            }

            int root = heapArray[0];

            heapArray[0] = heapArray[currentHeapSize - 1];
            currentHeapSize--;
            MinHeapify(0);
            return root;
        }

        public void deleteKey(int key) {
            decreaseKey(key, Integer.MIN_VALUE);
            extractMin();
        }

        private void MinHeapify(int key) {
            int l = leftChild(key);
            int r = rightChild(key);

            int smallest = key;
            if (l < currentHeapSize && heapArray[l] < heapArray[smallest]) {
                smallest = l;
            }

            if (r < currentHeapSize && heapArray[r] < heapArray[smallest]) {
                smallest = r;
            }

            if (smallest != key) {
                swap(heapArray, smallest, key);
                MinHeapify(smallest);
            }
        }

        public void increaseKey(int key, int newVal) {
            heapArray[key] = newVal;
            MinHeapify(key);
        }

        public void changeValueOnAKey(int key, int newVal) {
            if (heapArray[key] == newVal) {
                return;
            }

            if (heapArray[key] < newVal) {
                increaseKey(key, newVal);
            } else {
                decreaseKey(key, newVal);
            }
        }
    }

}