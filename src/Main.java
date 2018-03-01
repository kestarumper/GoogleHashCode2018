import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "a_example.in";
        int R, C,F, N, B, T;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            R = Integer.parseInt(parts[0]);
            C = Integer.parseInt(parts[1]);
            F = Integer.parseInt(parts[2]);
            N = Integer.parseInt(parts[3]);
            B = Integer.parseInt(parts[4]);
            T = Integer.parseInt(parts[5]);

//            int[][] roads = new int[N][6];
            ArrayList<Road> roads = new ArrayList<>();

            int row = 0;
            while ((line = br.readLine()) != null) {
                parts = line.split(" ");
                roads.add(
                    new Road(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5]),
                            row
                    )
                );
                row++;
            }

//            Arrays.sort(roads, (a, b) -> Integer.compare(a[4], b[4]));

            Collections.sort(roads, new Comparator<Road>() {
                @Override
                public int compare(Road road1, Road road2) {
                    return Integer.compare(road1.minStart, road2.minStart);
                }
            });

//            for (int[] road : roads) {
//                for (int i : road) {
//                    System.out.print(i + " ");
//                }
//                System.out.print("\n");
//            }

            for (Road road : roads) {
                System.out.println(road);
            }

            ArrayList<Car> cars = new ArrayList<>();
            for(int i = 0; i < F; i++) {
                cars.add(new Car(0,0));
            }

            for (Road road : roads) {
                int min = 9999999;
                Car tmp = null;
                for (Car car : cars) {
                    car.canHandle(road);
                    //  car.setNextFree(car.nextArrive);
                    if ( car.nextArrive < min) {
                        min = car.nextArrive;
                        tmp = car;
                    }
                }
                tmp.setNextFree(tmp.nextArrive);
                tmp.addRoad(road);
            }

            for (Car car : cars) {
                System.out.println(car);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
