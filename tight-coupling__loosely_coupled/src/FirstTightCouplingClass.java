/**
 * tight-coupling: khái niệm trong Java ám chỉ việc mối quan hệ giữa các Class quá chặt chẽ.
 * <p>
 * Với cách làm ở trên, TightCouplingClassService đã hoàn thiện được nhiệm vụ, tuy nhiên,
 * khi có yêu cầu thay đổi thuật toán sắp xếp sang TightCouplingClass khac' thì nghe vẻ chúng ta sẽ phải sửa lại hoàn toàn cả 2 Class trên.
 * <p>
 * Ngoài ra FirstTightCouplingClass sẽ chỉ tồn tại nếu TightCouplingClassService tồn tại,
 * vì TightCouplingClassService tạo đối tượng FirstTightCouplingClass bên trong nó
 * (hay nói cách khác là sự sống chết của FirstTightCouplingClass sẽ do TightCouplingClassService quyết định).
 */
public class FirstTightCouplingClass {

    public void methodFirstTightCouplingClass(int[] array) {
        System.out.println("method sort of TightCouplingClass");
    }
}

class TightCouplingClassService {

    private FirstTightCouplingClass firstTightCouplingClass;

    public TightCouplingClassService() {
        this.firstTightCouplingClass = new FirstTightCouplingClass();
    }

    public void method(int array[]) {
        firstTightCouplingClass.methodFirstTightCouplingClass(array);
    }
}
