package Chapter_2.FreeTraining;/*
    Muhammed Sabri Sahin
    16-Jan-19
    Chapter_2.FreeTraining

    https://youtu.be/D35llNtkCps
    1st question
*/

import java.util.ArrayList;

public class FindMthMin {
    public static void main(String args[]) {
        int input[] = {5, 2, 8, 0, 3, 100, 50, 75};
        System.out.println(findMin(input, 6));
    }

    private static int findMin(int[] input, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int order = 0;

        for(int i = 0; i < input.length; i++) {
            if(i < m) {
                if(list.size() > 0) {
                    int insert = list.size();
                    for(Integer check : list) {
                        if(check > input[i]) {
                            insert = 0;
                            break;
                        }
                    }
                    list.add(insert, input[i]);
                } else {
                    list.add(input[i]);
                }
            } else {
                boolean added = false;
                if(input[i] < list.get(m-1)){
                    int j = -1;
                    for( j = 0; j < m; j++) {
                        if(list.get(j) > input[i]) {
                            list.add(j, input[i]);
                            added = true;
                            break;
                        }
                    }
                    if(!added)
                        list.add(m-1, input[i]);
                }
            }
        }
        return list.get(m-1);
    }
}
