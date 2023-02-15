package tight_coupling;

// https://viblo.asia/p/dependency-injection-ap-dung-vao-spring-boot-nhu-the-nao-phan-1-WAyK8AWWZxX
class ChinaEngine {
}

class Car {
    /*
    1. Các module cấp cao không nên phụ thuộc (trực tiếp) vào module cấp thấp.
    Cả hai nên phụ thuộc vào abstraction (của OOP).
    2. Abstraction không nên phụ thuộc vào chi tiết, mà ngược lại.
     */
    private ChinaEngine engine;

    public Car() {
        // Khi tạo Car thì nhớ gắn engine vào :D
        engine = new ChinaEngine();
    }

    /*
    có thể thấy code đã vi phạm ý 1 của DI principle.
    Lý do là vì Car đã trực tiếp phụ thuộc vào ChinaEngine (do trong code class Car có sử dụng tới ChinaEngine),
     */
}
