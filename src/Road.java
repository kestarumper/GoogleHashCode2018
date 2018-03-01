public class Road {
    private final int id;
    public int start_pos_x;
    public int start_pos_y;
    public int end_pos_x;
    public int end_pos_y;
    public final int minStart;
    public final int maxEnd;

    public Road(int start_pos_x, int start_pos_y, int end_pos_x, int end_pos_y, int minStart, int maxEnd, int id) {
        this.start_pos_x = start_pos_x;
        this.start_pos_y = start_pos_y;
        this.end_pos_x = end_pos_x;
        this.end_pos_y = end_pos_y;
        this.minStart = minStart;
        this.maxEnd = maxEnd;
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+id;
    }
}
