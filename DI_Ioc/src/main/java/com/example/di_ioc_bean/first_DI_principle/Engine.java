package com.example.di_ioc_bean.first_DI_principle;

// https://viblo.asia/p/dependency-injection-ap-dung-vao-spring-boot-nhu-the-nao-phan-1-WAyK8AWWZxX
// Interface đại diện cho mọi loại động cơ
public interface Engine {
    void run();
}

class Human {
}

// ChinaEngine là một loại Engine
class ChinaEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền nhưng tốn xăng
    }
}

class VNEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền, ít tốn xăng
    }
}

// Trong Car thì chỉ dùng Engine (chung chung), không có cụ thể loại nào
// Loại engine cụ thể sẽ được inject vào lúc tạo (không phải gán cứng trong code)
// Do đó có thể tạo Car với các loại Engine khác nhau
/*
Sau khi sửa lại thì cả Car và ChinaEngine đều phụ thuộc vào interface Engine (đại diện cho abstraction). Như thế đúng với nguyên lý DI đặt ra */
class Car {
    // Loại engine nào đó, lợi dụng tính đa hình OOP
    private Engine engine;
    private Human owner;

    // Khi tạo Car thì tạo Engine object trước, rồi inject vào constructor này
    public Car(Engine engine, Human owner) {
        this.engine = engine;
        this.owner = owner;
    }

    // Do engine bắt buộc, nên dùng constructor based injection
    // Constructor-based có thể inject nhiều dependency cùng lúc
    public Car(Engine engine) {
        this.engine = engine;
    }

    // Do owner là tùy chọn, nên dùng setter based injection
    // Setter-based chỉ inject một dependency mỗi setter
    public void setOwner(Human owner) {
        this.owner = owner;
    }
    /*
Các loại injection. Có 2 loại chính:

- Constructor-based injection: Dùng inject các module bắt buộc.
Các module được inject nằm trong constructor, và được gán lần lượt vào các field.

- Setter-based injection: Dùng inject các module tùy chọn.
Mỗi module sẽ được inject thông qua setter, nằm ở tham số và cũng gán cho field nào đó.
 */

    /*
    Code trên lợi dụng tính đa hình của OOP để switch giữa các loại Engine mà không có lỗi gì xảy ra.
     */

    /*
    Đúng, nhưng việc này sẽ được thực hiện khi khởi tạo đối tượng Car.
    Nghĩa là khi tạo ra Car thì ta mới gắn Engine cho nó.
    Xem lại code đầu tiên, chúng ta đã gắn cứng ChinaEngine cho Car ngay trong bản thân Car,
    đúng ra việc đó thì phải thực hiện bên ngoài, khi tạo Car.
    Đó là sự khó khăn khi mối liên kết giữa chúng quá cứng.
     */
    public static void main(String[] args) {
        // Tạo động cơ trước
        Engine goodEngine = new VNEngine();
        Engine cheapEngine = new ChinaEngine();
        Human huy = new Human();

        /*
        Ví dụ trên chúng ta thực hiện gắn Engine vào Car trong constructor.
        Đây gọi là constructor-based injection, chúng ta sẽ bàn kĩ hơn ở phần sau.
         */
        Car myCar = new Car(goodEngine, huy);
        Car yourCar = new Car(cheapEngine, huy);
    }
}