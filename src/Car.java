import java.awt.*;
import java.util.ArrayList;

public class Car {
    private int pos_x;
    private int pos_y;
    private int nextFree = 0;
    public int nextArrive = 0;

    ArrayList<Road> roadsHandled = new ArrayList<>();

    void moveToPosition(int x, int y) {
        this.pos_x = x;
        this.pos_y = y;
    }

    int distanceTo(int x, int y) {
        return Math.abs(this.pos_x - x) + Math.abs(this.pos_y - y);
    }

    int distanceTo(int car_x, int car_y, int dest_x, int dest_y) {
        return Math.abs(car_x - dest_x)+Math.abs(car_y - dest_y);
    }

    boolean canHandle(Road road) {
        int toCustomer = distanceTo(road.start_pos_x, road.start_pos_y);
        int fromCustomerToDestination = distanceTo(road.start_pos_x, road.start_pos_y, road.end_pos_x, road.end_pos_y);
        nextArrive = nextFree + toCustomer + fromCustomerToDestination;
        return nextFree + toCustomer + fromCustomerToDestination <= road.maxEnd;
    }

    public void setNextFree(int nextFree) {
        this.nextFree = nextFree;
    }

    void addRoad(Road road) {
        this.roadsHandled.add(road);
    }

    public Car(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    @Override
    public String toString() {
        System.out.print(roadsHandled.size() + " ");
        for (Road road : roadsHandled) {
            System.out.print(road + " ");
        }
        return "";
    }
}
