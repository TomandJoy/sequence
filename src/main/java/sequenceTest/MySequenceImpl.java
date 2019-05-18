package sequenceTest;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

/**
 * 对象成员的初始化方式：
 * 1、提供get,set方法
 * 2、构造函数

 */

public class MySequenceImpl implements ISequence {
    //提供属性
    //数组
    private Object[] elem;
    //有效数据长度
    private int usedSize;
    //默认的数组长度
    private static final int DEFAULT_SIZE=10;
    //提供构造函数
    public MySequenceImpl(){
        //new一个数组,在堆上开辟了大小为DEFAULT_SIZE的空间
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public boolean add(int pos, Object data) {
        //1、对pos位置的合法性进行判断
        //2、判断顺序表是否为满
        if(pos<0 ||pos>this.usedSize){
            return false;
        }
        //如果顺序表满，则2倍扩容 数组拷贝 Arrays.copyOf   System.arraycopy()
        /**
         * Arrays.copyOf与System.arraycopy（）的区别
         * 1.返回值
         * copyOf的返回值是泛型，而arraycopy()的返回值是void
         * 2.arraycopy用native修饰，表示是一个本地方法，它的底层是使用C或C++写的，速度最快
         * copyOf底层其实也是调用了arraycopy()
         */
        if(isFull()==true){
            this.elem = Arrays.copyOf(elem,elem.length*2);
        }
        for (int i = usedSize-1; i >=pos; i--) {
                elem[i+1]=elem[i];

        }
        this.elem[pos]=data;
        usedSize++;
        return true;
    }

    public boolean isEmpty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }
    public int search(Object key) {
        //1.先判断顺序表是否为空，若为空返回false，否则遍历顺序表
        if(isEmpty()){
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i].equals(key)){
                return i;
            }

        }

        return -1;
    }

    public boolean contains(Object key) {
        if(isEmpty()){
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i].equals(key)){
                return true;
            }

        }

        return false;
    }

    /**
     * 判断pos位置的合法性
     * 判断顺序表是否为空
     * @param pos
     * @return
     */
    public Object getPostValue(int pos) {
        if(pos<0||pos>usedSize-1){
            return null;
        }
        if(isEmpty()){
            return null;
        }
        return this.elem[pos];
    }

    /**
     * 先找到key（调用search()函数）从后边往前覆盖，usedSize--
     * @param key
     * @return
     */
    public Object remove(Object key) {
        int i = search(key);
        for (int j = i; j <usedSize ; j++) {
            elem[j]=elem[j+1];
        }
        return key;
    }

    public int size() {
        return usedSize;
    }

    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();


    }

    public void clear() {
        for (int i = 0; i < usedSize; i++) {
            this.elem[i]=null;
        }

    }
}
