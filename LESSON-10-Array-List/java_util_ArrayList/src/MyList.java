import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements [] = new Object[DEFAULT_CAPACITY];
    private MyList (){}
    MyList(int capacity){
        elements = new Object[capacity];
    }
    String print(){
        elements = Arrays.copyOf(elements, size); //sao chép kích thước và số phần tử
        return Arrays.toString(elements);//chuyển đổi thành chuỗi
    }
    private void ensureCapacity (int minCapacity){ //đảm bảo mảng có đủ dung lượng để lưu trữ phần tử mới
        if (size == elements.length){
            int newSize = elements.length +  minCapacity; //tạo mảng mới
            elements = Arrays.copyOf(elements, newSize);//mảng cũ sẽ được sao chép sang mảng mới
        }
    }
    void add(int index, E e) { //thêm 1 phần tử vào vị trí chỉ định
        if (size == 0) { //nếu kích thước mảng bằng 0
            ensureCapacity(1);//đảm bảo mảng có đủ dung lượng để chứa phần tử mới
            elements[size++] = e; //phần tử e vào mảng và biến size được tăng lên 1
        } else if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " , Size " + index);
        } else {
            ensureCapacity(1);
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1]; //các phần tử từ vị trí index trở về sau sẽ được dịch sang phía sau mở đường cho phần tử mới
            }
            elements[index] = e; //phần tử e được thêm vào vị trí index
            size++;
        }
    }
    boolean add (E e){ //thêm 1 phần tử mới vào cuối mảng
        ensureCapacity(2);//gọi để đảm bảo mảng có đủ dung lượng để chứa phần tử mới
        elements[size++] = e; //phần tử e được thêm vào mảng tại ví size và biến size được tăng thêm 1
        return true; //thông báo thêm phần tử thành công
    }
    E remove (int index){ //xóa phần tử tại một vị trí cụ thể
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        E temp = (E) elements[index];
        for (int i = index ; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        size--;
        elements = Arrays.copyOf(elements,size);
        return temp;
    }
    int size(){
        return size;
    }
    }


