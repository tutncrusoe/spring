public interface Interface {
    void methodInterface(int[] array);
}

class classImplementsInterface implements Interface {
    @Override
    public void methodInterface(int[] array) {
        System.out.println("Đã sap xep bang thuat toan classImplementsInterface");
    }
}

/**
 * Với cách làm này,
 * VeryComplexService sẽ chỉ quan hệ với một interface Interface.
 * Với cách này thì mỗi quan hệ giảm bớt sự liên kết,
 * nhưng nó không thay đổi được việc thuật toán vẫn đang là classImplementsInterface.
 */
class ClassService {

    private Interface anInterface;

    public ClassService() {
        this.anInterface = new classImplementsInterface();
    }

    public void method(int[] array) {
        anInterface.methodInterface(array);
    }
}