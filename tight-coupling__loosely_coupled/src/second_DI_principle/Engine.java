package second_DI_principle;


interface Engine {
    /*
    Ý thứ hai của DI principle khá đễ hiểu nếu bạn nắm vững OOP.
    Cụ thể, nguyên tắc “abstraction không nên phụ thuộc vào chi tiết,
    mà ngược lại” có nghĩa là abstraction chỉ lấy những thuộc tính,
    những hành động chung nhất,
    mà không cần quan tâm chi tiết bên trong chúng hoạt động thế nào.
     */
    // Mọi loại Engine đều có thể run
    void run();
}

// Động cơ VNEngine run theo hiểu khác
class VNEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền, ít tốn xăng
    }
}

// Động cơ ChinaEngine run theo kiểu khác
class ChinaEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền nhưng tốn xăng
    }
}

/*
Lấy lại ví dụ về Engine ở trên, chúng ta chỉ cần biết abstraction Engine có method là run,
còn những loại động cơ khác nhau thực hiện run như thế nào (chi tiết) thì không cần quan tâm.
 */

