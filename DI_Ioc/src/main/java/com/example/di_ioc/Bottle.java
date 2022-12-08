package com.example.di_ioc;

/**
 * #1
 * Trước hết, qua đoạn code này,
 * bạn sẽ thấy là khi bạn tạo ra một Bottle,
 * bạn sẽ tạo ra thêm 1 bộ Shape đi kèm với bottle đó. Lúc này,
 * ShapeClass tồn tại mang ý nghĩa là dependency (phụ thuộc) của Bottle.
 */
public class Bottle {
    /**
     * Khi tao ra thuoc tinh nhu vay,
     * ban vo tinh tao ra mot diem bottleneck trong chuong trinh cua minh,
     * gia su, Bottle muon thay doi ShapeClass => Material thi phai thay doi ShapeClass.
     * <p>
     * Hay nguy hiem hon, ShapeClass bi loi, (class ShapeClass khong hoat dong) no se
     * anh huong truc tiep den Bottle.
     */
    private ShapeClass shapeClass;

    public Bottle() {
        this.shapeClass = new ShapeClass();
    }


}

class ShapeClass {

}
