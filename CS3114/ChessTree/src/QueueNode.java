public class QueueNode {
    private String entry;
    private int fitness;
    private QueueNode next;

    public QueueNode(String entry, int fitness) {
        this.entry = entry;
        this.fitness = fitness;
        this.next = null;
    }

    public String getEntry() {
        return this.entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public QueueNode getNext() {
        return this.next;
    }  

    public void setNext(QueueNode next) {
        this.next = next;
    }    

    public int getFitness() {
        return this.fitness;
    }
}
