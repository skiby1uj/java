import java.util.Collection;
import objectexplorer.MemoryMeasurer;

/**
 * Created by kamil on 26.10.2015.
 */
public class CollectionsTests <T extends Collection> {
    private T obj;
    private final Class className;

    CollectionsTests(T obj) {
        this.obj = obj;
        this.className = obj.getClass();
    }

    void testAndWrite(int numberOfElements) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Size of 1 element in " + toString() + " " + testSize() + " bytes");
        //System.out.println("Add " + numberOfElements + " elements to " + toString() + " took " + testAdd(numberOfElements) + "ms");
        //System.out.println("Contains " + numberOfElements / 10 + " elements of " + toString() + " took " + testContains(numberOfElements / 10) + "ms");
        
        System.out.println("Remove " + numberOfElements + " elements of " + toString() + " took " + testRemove(numberOfElements) + "ms");
    }

    private long testSize() {
        long memory = MemoryMeasurer.measureBytes(obj);
        try {
            obj.add(1.0);
        }
        catch (Exception e) {
            //do nothing
        }
        return MemoryMeasurer.measureBytes(obj) - memory;
    }

//    public long testAdd(int numberOfElements) {
//        long start, end;
//        start = System.currentTimeMillis();
//
//        for (double i = 0; i < numberOfElements; i++) {
//            try {
//                obj.add(i);
//            }
//            catch(Exception e) {
//                // do nothing
//            }
//        }
//
//        end = System.currentTimeMillis();
//        return end - start;
//
//    }

    public long testRemove(int numberOfElements) {
        long start, end;
        start = System.currentTimeMillis();

        for (double i = 0; i < numberOfElements; i++) {
            obj.remove(i);
        }

        end = System.currentTimeMillis();
        return end - start;
    }

//    public long testContains(int numberOfElements) {
//        long start, end;
//        start = System.currentTimeMillis();
//
//        for (double i = 0; i < numberOfElements; i++) {
//            obj.contains(i);
//        }
//
//        end = System.currentTimeMillis();
//        return end - start;
//    }

    @Override
    public String toString() {
        return className.toString().substring(className.toString().lastIndexOf(".") + 1);
    }
}
