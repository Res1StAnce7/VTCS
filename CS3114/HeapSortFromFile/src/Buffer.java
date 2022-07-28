import java.nio.ByteBuffer;

/**
 * This class represents a single buffer
 * 
 * @author Siliang Zhang
 * @version 06/22/2022
 */
public class Buffer {
    private ByteBuffer myBuffer; 
    private boolean isDirty;
    private int offset;
    private final int blockSize = 4096;
    /**
     * Constructor for the buffer.
     * 
     * @param offset
     *            the offset.
     * @param bytes 
     *            the bytes in the buffer.
     */
    public Buffer(int offset, byte[] bytes) {
        this.myBuffer = ByteBuffer.allocate(this.blockSize);
        this.isDirty = false;
        this.offset = offset;
        this.myBuffer.put(bytes);
    }


    /**
     * Set short at the given offset.
     * 
     * @param pos 
     *          the pos.
     * @param val 
     *          the value.
     */
    public void putShort(int pos, short val) {
        this.myBuffer.putShort(pos - this.offset, val);
    }


    /**
     * The getter for the buffer.
     * 
     * @return the buffer.
     */
    public byte[] array() {
        return this.myBuffer.array();
    }


    /**
     * Clear the buffer.
     */
    public void clear() {
        this.myBuffer.clear();
    }


    /**
     * Get the short value at the given offset.
     * 
     * @param pos 
     *          the pos.
     * @return the short value.
     */
    public short getShort(int pos) {
        return this.myBuffer.getShort(pos - this.offset);
    }


    /**
     * Set the dirty flag.
     */
    public void setDirty() {
        this.isDirty = true;
    }


    /**
     * Get the dirty flag.
     * 
     * @return the dirty flag.
     */
    public boolean isDirty() {
        return this.isDirty;
    }


    /**
     * Get the offset.
     * 
     * @return the offset.
     */
    public int getOffset() {
        return this.offset;
    }


    /**
     * Get the bytes array
     * 
     * @return the bytes array.
     */
    public byte[] getBytes() {
        return this.myBuffer.array();
    }


    /**
     * Check if the given offset is in the buffer.
     * @param pos the offset.
     * @return true if the offset is in the buffer, false otherwise.
     */
    public boolean inBuffer(int pos) {
        return pos >= this.offset && pos < this.offset + this.blockSize;
    }
}
