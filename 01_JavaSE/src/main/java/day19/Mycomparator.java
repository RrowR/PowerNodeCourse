package day19;

import java.util.Comparator;

public class Mycomparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (((Trunk) o1).getBirDate().getTime() > ((Trunk) o2).getBirDate().getTime()){
            return 1;
        }else if (((Trunk) o1).getBirDate().getTime() < ((Trunk) o2).getBirDate().getTime()){
            return -1;
        }
        return 0;
    }
}
