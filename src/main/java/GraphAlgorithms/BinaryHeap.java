package GraphAlgorithms;


public class BinaryHeap {

    private int[] nodes;
    private int pos;

    public BinaryHeap() {
        this.nodes = new int[32];
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i] = Integer.MAX_VALUE;
        }
        this.pos = 0;
    }

    public void resize() {
        int[] tab = new int[this.nodes.length + 32];
        for (int i = 0; i < nodes.length; i++) {
            tab[i] = Integer.MAX_VALUE;
        }
        System.arraycopy(this.nodes, 0, tab, 0, this.nodes.length);
        this.nodes = tab;
    }

    public boolean isEmpty() {
        return pos == 0;
    }

    public void insert(int element) {

        int tmp = pos;
        this.nodes[pos] = element;
        this.pos++;
        boolean stop = false;
        while(!stop && ((tmp - 1 )/ 2) >= 0){

            if (this.nodes[tmp] < this.nodes[((tmp - 1 )/ 2)]){
                this.nodes[tmp] = this.nodes[((tmp - 1 )/ 2)];
                this.nodes[((tmp - 1 )/ 2)] = element;
                tmp = ((tmp - 1 )/ 2);
            } else {
                stop = true;
            }
        }

    }

    public int remove() {
        int position =0;
    	int x = this.nodes[position];
        this.nodes[position] = this.nodes[this.pos-1];
        this.nodes[this.pos-1] = Integer.MAX_VALUE;
        pos--;
    	int y;

        while ((this.nodes[position] > this.nodes[2*position+1]) || ( this.nodes[position] > this.nodes[2*position+2])){

            System.out.println("t0 " + position);

            if (this.nodes[position] > this.nodes[2*position+1]) {
                y=this.nodes[position];
                this.nodes[position]=this.nodes[2*position+1];
                this.nodes[2*position+1]=y;
                position=(2*position+1);
                System.out.println("t1 " + position);

            }

            else if (this.nodes[position] > this.nodes[2*position+2]) {
                y=this.nodes[position];
                this.nodes[position]=this.nodes[2*position+2];
                this.nodes[2*position+2]=y;
                position=(2*position+2);
                System.out.println("t2 " + position);
            }

            if ((2*position+2)>=32){
                return x;
            }
        }
    	return x;
    }

    private int getBestChildPos(int src) {
        if (isLeaf(src)) { // the leaf is a stopping case, then we return a default value
            return Integer.MAX_VALUE;
        } else {
        	// A completer
        	return Integer.MAX_VALUE;
        }
    }

    
    /**
	 * Test if the node is a leaf in the binary heap
	 * 
	 * @returns true if it's a leaf or false else
	 * 
	 */	
    private boolean isLeaf(int src) {
    	// A completer
    	return ((2 * src) + 1) >= this.pos;
    }

    private void swap(int father, int child) {
        int temp = nodes[father];
        nodes[father] = nodes[child];
        nodes[child] = temp;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            s.append(nodes[i]).append(", ");
        }
        return s.toString();
    }

    /**
	 * Recursive test to check the validity of the binary heap
	 * 
	 * @returns a boolean equal to True if the binary tree is compact from left to right
	 * 
	 */
    public boolean test() {
        return this.isEmpty() || testRec(0);
    }

    private boolean testRec(int root) {
        boolean x;
        if (isLeaf(root)) {
            return true;
        } else {
            int left = 2 * root + 1;
            int right = 2 * root + 2;
            if (right >= pos) {
                return nodes[left] >= nodes[root] && testRec(left);
            } else {
                x= nodes[left] >= nodes[root] && testRec(left) && nodes[right] >= nodes[root] && testRec(right);
                System.out.println(x);
                return x;
            }
        }
    }

    public static void main(String[] args) {
        BinaryHeap jarjarBin = new BinaryHeap();
        System.out.println(jarjarBin.isEmpty()+"\n");
        int k = 20;
        int m = k;
        int min = 2;
        int max = 20;
        while (k > 0) {
            int rand = min + (int) (Math.random() * ((max - min) + 1));
            System.out.print("insert " + rand + " ");
            jarjarBin.insert(rand);
            k--;
        }


        System.out.println("\n" + jarjarBin);
        System.out.println(jarjarBin.test());

        System.out.println();
        System.out.println("remove"+ jarjarBin.remove());
        System.out.println("\n" + jarjarBin);
        System.out.println(jarjarBin.test());
    }

}
