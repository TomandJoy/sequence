package sequenceTest;

public class TestDemo {
    public static void main(String[] args) {
        MySequenceImpl mySequence = new MySequenceImpl();
        for (int i = 0; i < 20 ; i++) {
            mySequence.add(i,i);

        }
        mySequence.display();
        mySequence.add(1,99);
        mySequence.display();
        int ret1 = mySequence.search(99);
        System.out.println(ret1);
        boolean ret2 =mySequence.contains(123);
        System.out.println(ret2);
        Object n1 = mySequence.getPostValue(2);
        System.out.println(n1);
        Object k = mySequence.remove(11);
        System.out.println(k);
        mySequence.display();




    }

}
