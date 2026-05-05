import java.util.*;

interface X {
    int m();
}

class S implements X {
    private T objT;

    public S(T x) {
        this.objT = x;
    }

    public int m() {
        if (objT == null) {
            return 1;
        } else {
            return 1 + objT.m();
        }
    }
}

class T implements X {
    private List<X> obj;

    public T() {
        obj = new ArrayList<>();
    }

    public void add(X x) {
        obj.add(x);
    }

    public int m() {
        int sum = 0;
        for (X x : obj) {
            sum += x.m();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        T p1= new T();
        T p2= new T();
        T p3= new T();
        p1.add(p2);
        p2.add(p3);
        S s1= new S(p1);
        S s2= new S(p2);
        S s3= new S(p3);
        System.out.println(s1.m());
        System.out.println(s2.m());
        System.out.println(s3.m());
    }
}