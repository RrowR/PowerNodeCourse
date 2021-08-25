package day19;

import java.util.ArrayList;
import java.util.Comparator;

public class Listsort {
    public static void main(String[] args) {
        ArrayList<Trunk> list = new ArrayList<>();
        list.add(new Trunk("南", 200.0, "2020-03-11", "second"));
        list.add(new Trunk("东", 100.0, "2020-03-10", "first"));
        list.add(new Trunk("西", 300.0, "2020-02-11", "third"));
        list.add(new Trunk("北", 400.0, "2019-05-11", "forth"));
        list.sort(new Comparator<Trunk>() {
            @Override
            public int compare(Trunk o1, Trunk o2) {
                if (o1.getBirDate().getTime() >  o2.getBirDate().getTime()){
                    return 1;
                }else if ( o1.getBirDate().getTime() <  o2.getBirDate().getTime()){
                    return -1;
                }
                return 0;
            }
        });

        list.sort(((o1, o2) -> {
            if (o1.getBirDate().getTime() > o2.getBirDate().getTime()) {
                return 1;
            } else if (o1.getBirDate().getTime() < o2.getBirDate().getTime()) {
                return -1;
            }
            return 0;
        }));


        for (Trunk trunk : list) {
            System.out.println(trunk);
        }
    }
}
