package sequenceTest;

public interface ISequence {
    //在pos位置插入value
    boolean add(int pos,Object data);
    //查找关键字key,找到返回key的下标，没有返回-1
    int search(Object key);
    //查找是否包含关键字key,是否在顺序表中
    boolean contains(Object key);
    //得到pos位置的值
    Object getPostValue(int pos);
    //删除第一次出现的关键字key
    Object remove(Object key);
    //得到顺序表的长度
    int size();
    //打印顺序表
    void display();
    //清空顺序表以防内存泄漏
    void clear();

}
