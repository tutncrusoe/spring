/**
 * Cách thứ ba này cũng là cách làm phổ biển nhất.
 * Mối liên hệ giữa 2 Class: FirstClassImplParentInterface and SecondClassImplParentInterface đã "lỏng lẻo" hơn trước rất nhiều.
 * LooselyCoupledClassService sẽ không quan tâm tới việc thuật toán sắp xép là gì nữa, mà chỉ cần tập trung vào nghiệp vụ.
 * Còn ParentInterface sẽ được đưa vào từ bên ngoài tùy theo nhu cầu sử dụng.
 *
 * https://viblo.asia/p/khai-niem-tight-coupling-lien-ket-rang-buoc-va-cach-loosely-coupled-63vKjVERK2R
 */
public interface ParentInterface {
    public void methodParentInterface(int[] array);
}

class FirstClassImplParentInterface implements ParentInterface {
    @Override
    public void methodParentInterface(int[] array) {
        System.out.println("methodFirstClassImplParentInterface");
    }
}

class SecondClassImplParentInterface implements ParentInterface {
    @Override
    public void methodParentInterface(int[] array) {
        System.out.println("methodSecondClassImplParentInterface");
    }
}

class LooselyCoupledClassService {
    private ParentInterface parentInterface;

    public LooselyCoupledClassService(ParentInterface parentInterface) {
        this.parentInterface = parentInterface;
    }

    public void methodLooselyCoupledClassService(int[] array) {
        parentInterface.methodParentInterface(array);
    }
}

class Main {
    public static void main(String[] args) {
        ParentInterface objectFirstClassImplParentInterface = new FirstClassImplParentInterface();
        LooselyCoupledClassService looselyCoupledClassService1 = new LooselyCoupledClassService(objectFirstClassImplParentInterface);

        ParentInterface objectSecondClassImplParentInterface = new SecondClassImplParentInterface();
        LooselyCoupledClassService looselyCoupledClassService2 = new LooselyCoupledClassService(objectSecondClassImplParentInterface);

    }
}


