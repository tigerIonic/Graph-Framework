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
    	// A completer
        System.out.println("Adding : " +  element + " in ");
        System.out.print("[");
        for(int e : this.nodes){
            System.out.print(e + " , ");
        }
        System.out.println("]");
        int tmp = pos;
        this.nodes[pos] = element;
        this.pos++;
        boolean stop = false;
        while(!stop && ((tmp - 1 )/ 2) > 0){
            System.out.println(this.nodes[tmp] + " < " + this.nodes[((tmp - 1 )/ 2)] + " ? " );
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

        int self = this.nodes[position];
    	int son1= this.nodes[2*position+1];
    	int son2= this.nodes[2*position+1];
    	int y;

        while (( self < son1) || ( self < son2)){

            self = this.nodes[position];
            son1= this.nodes[2*position+1];
            son2= this.nodes[2*position+1];

            if (self < son1) {
                y=self;
                self=son1;
                son1=y;
                position=position+1;
            }

            if (self < son2) {
                y=self;
                self=son2;
                son1=y;
                position=position+2;
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
    	return false;
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
        if (isLeaf(root)) {
            return true;
        } else {
            int left = 2 * root + 1;
            int right = 2 * root + 2;
            if (right >= pos) {
                return nodes[left] >= nodes[root] && testRec(left);
            } else {
                return nodes[left] >= nodes[root] && testRec(left) && nodes[right] >= nodes[root] && testRec(right);
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
            System.out.print("insert " + rand);
            jarjarBin.insert(rand);            
            k--;
        }
        System.out.println("remove"+ jarjarBin.remove());
        System.out.println("\n" + jarjarBin);
        System.out.println(jarjarBin.test());
    }

}
