package com.example.di_ioc;

/**
 * #2
 */
interface ShapeInterface {
    void printShape();
}

/**
 * RectangleImpl la` 1 abstract class.
 */
class RectangleImpl implements ShapeInterface {
    @Override
    public void printShape() {
        System.out.println("Rectangle");
    }
}

public class BottleDI {
    /**
     * Bay gio, ShapeDI chi phu thuoc vao Shape.
     * Neu muon thay doi, ta chi can mot ShapeImpl khac.
     */
    private ShapeInterface shapeInterface;

    /**
     * BottleDI van bi gan' voi mot Rectangle duy nhat.
     * Khong the thay the bang ShapeImpl khac'.
     */
    public BottleDI() {
        this.shapeInterface = new RectangleImpl();
    }

    /**
     * Vậy muốn thay doi hinh dang cho bottleDI, bạn phải làm như sau.
     * Chung ta da~ tach duoc RectangleImpl ra hoan toan khoi Bottle.
     * Dieu nay` lam` giam su phu thuoc giua Bottle va` RectangleImpl.
     * Lam` tang tinh tuy` bien, linh hoat cho code.
     */
    public BottleDI(ShapeInterface shapeInterface) {
        this.shapeInterface = shapeInterface;
    }
}

class Main {
    public static void main(String[] args) {
        // Tao ra mot doi tuong RectangleImpl
        ShapeInterface rectangle = new RectangleImpl();
//        ColorInterface color = new Red();
//        MaterialInterface material = new Plastic();

        // Inversion of Control
        /**
         * Dependency Injection giúp chúng ta dễ dàng mở rộng code và giảm sự phụ thuộc giữa các dependency với nhau.
         * Tuy nhiên, lúc này, khi code bạn sẽ phải kiêm thêm nhiệm vụ Inject dependency (tiêm sự phụ thuộc).
         * Thử tưởng tượng một Class có hàng chục dependency thì bạn sẽ phải tự tay inject từng ý cái.
         * Việc này lại dẫn tới khó khăn trong việc code, quản lý code và dependency
         *
         * Giá như lúc này có thằng làm hộ được chúng ta việc này thì tốt biết mấy. Vay thi` tim hieu BottleIoC cung` minh` nhe/
         */

        /**
         * Bay gio, BottleDI se hoat dong voi RectangleImpl.
         */
        BottleDI bottleDI = new BottleDI(rectangle);
    }
    /**
     * Bay gio muon BottleDI co shape ntn, ban chi can create one ShapeImpl implements ShapeInterface
     * va` Inject va`o trong BottleDI is done.
     *
     * Các cách để Inject dependency vào một đối tượng có thể kể đến như sau:
     *
     * Constructor Injection: Cái này chính là ví dụ của mình, tiêm dependency ngay vào Contructor cho tiện.
     *
     * Setter Injection: Ồ, sao không chứ 😗 chúng ta học về Setter từ những bài học vỡ lòng rồi, quá hợp lý.
     * Xài bottleDI.setShapeInterface(new ShapeImpl()) 😈
     *
     * Interface Injection: Mỗi Class muốn inject cái gì, thì phải implement một Interface có chứa một hàm inject(xx) (Gần như thay thế cho setter ý bạn).
     * Rồi bạn muốn inject gì đó thì gọi cái hàm inject(xx) ra. Cách này hơi dài và khó cho người mới.
     */
}
