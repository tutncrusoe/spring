package com.example.di_ioc_bean.IoC;
// https://viblo.asia/p/dependency-injection-ap-dung-vao-spring-boot-nhu-the-nao-phan-2-3P0lP1wG5ox

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
- Trong phần trước chúng ta đã tìm hiểu nguyên lý Dependency inversion,
và đã nắm được nguyên tắc để viết code tốt hơn.
Tuy nhiên, DI principle chỉ đơn giản là nguyên lý thôi,
còn việc thực hiện thì không nói rõ. Chúng ta có thể thực hiện như phần trước,
là tạo từng object riêng rẽ, sau đó gắn chúng lại với nhau (qua constructor).

- Tuy nhiên, nếu chương trình có nhiều module, nhiều object thì sẽ gặp tình trạng như:
* Gắn thiếu module vào module khác
* Phải quan tâm tới thứ tự khởi tạo module (tạo module nào trước)
* Phụ thuộc vòng (A phụ thuộc B, và B cũng phụ thuộc A, suy ra không biết tạo A hay B trước)
 */

/*
IoC nhằm mục đích đơn giản hóa quá trình tạo đối tượng và liên kết giữa chúng,
bằng cách tuân theo nguyên tắc:
Không tạo đối tượng, chỉ mô tả cách chúng sẽ được tạo ra.

IoC framework sẽ có các thành phần có sẵn làm nhiệm vụ tạo,
quản lý các đối tượng trong chương trình.
IoC sẽ quản lý, phân tích các mối phụ thuộc,
tạo các đối tượng theo thứ tự phù hợp nhất và liên kết chúng lại với nhau,
theo cách lập trình viên mô tả.
 */

/*
Các loại injection. Có 2 loại chính:

- Constructor-based injection: Dùng inject các module bắt buộc.
Các module được inject nằm trong constructor, và được gán lần lượt vào các field.

- Setter-based injection: Dùng inject các module tùy chọn.
Mỗi module sẽ được inject thông qua setter, nằm ở tham số và cũng gán cho field nào đó.
 */

@Component
class Human {
}

// @Component là bảo IoC container tạo một object duy nhất (singleton)
// Có hai cách giải quyết vấn đề này. Thứ nhất là dùng @Primary đánh dấu lên một bean. Khi đó bean này sẽ được ưu tiên chọn hơn, trong trường hợp có nhiều bean phù hợp trong context.
// Cách 2 là chỉ định rõ tên bean (tên class) cụ thể được inject bằng @Qualifier.
@Component // Mỗi class được đánh dấu @Component (cái này gọi là Annotation trong java) sẽ được IoC hiểu là một module
@Primary
class VNEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền, ít tốn xăng
    }
}

/*
Có thể hiểu do Spring Boot đã tìm thấy hai bean phù hợp để inject vào Car.
Do cả hai VNEngine và ChinaEngine đều implements Engine, mà Car cần Engine nên không biết nên chọn cái nào.
 */
class ChinaEngine implements Engine {
    @Override
    public void run() {
        // Run nhanh, bền, tốn xăng
    }
}

@Component
public class Car {

    // Tìm object tương ứng với Engine và chèn (inject) vào đây
    // @Autowired là tìm module tương ứng (tạo từ trước) và inject vào đó.
    /*
    Cách dùng @Autowired trên field là không được khuyến khích, do nó sử dụng Java reflection để inject. Chúng ta nên cân nhắc đổi qua dùng inject theo kiểu constructor hoặc setter.
     */

    @Autowired
    @Qualifier("VNEngine")
    private Engine engine;

    /*
    Code inject theo kiểu constructor-based nên dùng khi các module là bắt buộc.
    Khi đó Spring Boot khi tạo bean (cũng chỉ là tạo object, gọi constructor thôi) thì sẽ đưa các phụ thuộc vào constructor khi gọi.

Ví dụ class Car đã được sửa lại để inject Engine vào qua constructor.
     */
    // Các bản Spring Boot mới thì không cần @Autowired trên constructor
    /*
    public Car(Engine engine) {
        this.engine = engine;
    }
     */


    // Hoặc dùng kiểu setter-based như sau. Spring Boot sau khi tạo xong bean Car sẽ gọi thêm method setEngine() sau đó.
    /*
    // Thêm @Required để setter luôn được gọi để inject
    @Required
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
     */
}

/*
Mọi module trong IoC đều gọi là dependency,
mặc dù có những module không bị phụ thuộc bởi module nào khác.
Khi chương trình chạy, IoC sẽ quét tất cả class đánh dấu dependency,
tạo một đối tượng duy nhất (singleton), và bỏ vào cái túi gọi là IoC container,
lúc nào cần thì lấy ra sử dụng. Do đó, các module đảm bảo được IoC tạo ra duy nhất một object,
giúp tiết kiệm bộ nhớ và quản lý cũng dễ hơn.
 */

/*
Nếu khi tạo module nào đó, mà module đó cần một module khác phụ thuộc,
thì IoC sẽ tìm trong IoC container xem có không, nếu có thì inject vào,
nếu chưa thì tạo mới, bỏ vào container và inject vào.
Việc inject tự động các dependency (module) như thế được gọi là 'Dependency injection'.
 */

/*
*Spring là một framework được xây dựng dựa trên nguyên lý Dependency injection.
Bản thân Spring có chứa IoC container, có nhiệm vụ tạo và quản lý các module:
- IoC container của Spring gọi là Application context.
- Các module chứa trong IoC container được Spring gọi là các Bean.
* Spring Boot sử dụng các annotation dạng như @Component để đánh dấu lên class, chỉ ra rằng class đó cần tạo một module. Ngoài @Component, còn có các annotation khác như @Repository, @Controlller, @Service,... cũng được đánh dấu là module.
Khi ứng dụng Spring Boot chạy, thì IoC container sẽ thực hiện quá trình như sau:

* Quét tìm (scan) các class được đánh dấu là Bean, và tạo một object singleton, bỏ vào IoC container
Khi có một Bean phụ thuộc vào Bean khác, thì IoC sẽ tìm trong container, nếu chưa có thì tạo, nếu đã có thì lấy ra và inject vào bean cần nó
 */
