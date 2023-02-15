package first_DI_principle;

// deprecapted.Interface đại diện cho mọi loại động cơ
interface Engine {
}

// ChinaEngine là một loại Engine
class ChinaEngine implements Engine {
}

class VNEngine implements Engine {
}

// Trong Car thì chỉ dùng Engine (chung chung), không có cụ thể loại nào
// Loại engine cụ thể sẽ được inject vào lúc tạo (không phải gán cứng trong code)
// Do đó có thể tạo Car với các loại Engine khác nhau
/*
Sau khi sửa lại thì cả Car và ChinaEngine đều phụ thuộc vào interface Engine (đại diện cho abstraction). Như thế đúng với nguyên lý DI đặt ra */
class Car {
    // Loại engine nào đó, lợi dụng tính đa hình OOP
    private Engine engine;

    // Khi tạo Car thì tạo Engine object trước, rồi inject vào constructor này
    public Car(Engine engine) {
        this.engine = engine;
    }

    /*
    Code trên lợi dụng tính đa hình của OOP để switch giữa các loại Engine mà không có lỗi gì xảy ra.
     */

    /*
    Đúng, nhưng việc này sẽ được thực hiện khi khởi tạo đối tượng Car.
    Nghĩa là khi tạo ra Car thì ta mới gắn Engine cho nó.
    Xem lại code đầu tiên, chúng ta đã gắn cứng ChinaEngine cho Car ngay trong bản thân Car,
    đúng ra việc đó thì phải thực hiện bên ngoài, khi tạo Car.
    Đó là sự khó khăn khi mối liên kết giữa chúng quá cứng.
     */ {
        // Tạo động cơ trước
        Engine goodEngine = new VNEngine();
        Engine cheapEngine = new ChinaEngine();

        /*
        Ví dụ trên chúng ta thực hiện gắn Engine vào Car trong constructor.
        Đây gọi là constructor-based injection, chúng ta sẽ bàn kĩ hơn ở phần sau.
         */
        Car myCar = new Car(goodEngine);
        Car yourCar = new Car(cheapEngine);  // and bad :)
    }
}