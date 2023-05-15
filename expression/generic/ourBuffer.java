package expression.generic;

import java.util.ArrayList;

public class ourBuffer {
    private int iterator = 0;

    public ArrayList<elementOperation> buffer;

    public ourBuffer(ArrayList<elementOperation> buffer) {
        this.buffer = buffer;
    }

    public elementOperation next() {
        return buffer.get(iterator++);
    }

    public void previous() {
        iterator--;
    }

    public int position() {
        return iterator;
    }
}