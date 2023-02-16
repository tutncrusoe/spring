package com.example.di_ioc_bean.Bean;

// https://viblo.asia/p/spring-boot-1-huong-dan-atcomponent-va-atautowired-E375zXvJZGW
// https://viblo.asia/p/bean-va-applicationcontext-la-gi-trong-spring-boot-Ljy5Vjwj5ra

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DiIocApplication {

    public static void main(String[] args) {
        /*
        Bạn sẽ hiểu, một trong những nhiệm vụ chính của Spring là tạo ra một cái Container chứa các Dependency cho chúng ta.
        SpringApplication.run(App.class, args) chính là câu lệnh để tạo ra container
        . Sau đó nó tìm toàn bộ các dependency trong project của bạn và đưa vào đó.

Spring đặt tên cho container là ApplicationContext
         */
//        SpringApplication.run(DiIocApplication.class, args);

        /**
         * bean là những module chính của chương trình, được tạo ra và quản lý bởi Spring IoC container.
         */
        /*
        Các bean có thể phụ thuộc lẫn nhau, như ví dụ về Car, Engine và ChinaEngine từ đầu series tới giờ.
        Sự phụ thuộc này được mô tả cho IoC biết nhờ cơ chế Dependency injection.
        Cách đánh dấu class là một bean thì mình sẽ trình bày trong bài tiếp theo.
        Lúc này các bạn chỉ cần biết đơn giản nhất là dùng @Component lên class là class đó là một bean.
         */
        /*
        ApplicationContext là khái niệm Spring Boot dùng để chỉ Spring IoC container
        , tương tự như bean là đại diện cho các dependency.

Ngoài ra bạn có thể sẽ nghe nói về BeanFactory. Nó cũng đại loại như ApplicationContext
, đại diện cho Spring IoC container nhưng ở mức cơ bản. ApplicationContext thì ở mức cao hơn
, cung cấp nhiều tính năng hơn BeanFactory như i18n, resolving messages, publishing events,...
         */
        // ApplicationContext chính là container, chứa toàn bộ các Bean
        // Spring đặt tên cho container là ApplicationContext
        // và đặt tên cho các dependency là Bean
        // ApplicationContext chứa toàn bộ dependency trong project.
        ApplicationContext context = SpringApplication.run(DiIocApplication.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        // Lấy Bean ra bằng cách
        Outfit outfit = context.getBean(Outfit.class);

        // In ra để xem thử nó là gì
        System.out.println("Outfit Instance: " + outfit);
        // xài hàm wear()
        outfit.wear();

        Girl girl = context.getBean(Girl.class);

        System.out.println("Girl Instance: " + girl);

        System.out.println("Girl Outfit: " + girl.outfit);

        girl.outfit.wear();
    }
    
    /*
    Spring Boot khi chạy sẽ dò tìm toàn bộ các Class cùng cấp 
    hoặc ở trong các package thấp hơn so với class App mà bạn cung cấp cho Spring 
    (Chúng ta có thể cấu hình việc tìm kiếm này, sẽ đề cập sau). 
    Trong quá trình dò tìm này, khi gặp một class được đánh dấu @Component thì nó sẽ tạo ra một instance 
    và đưa vào ApplicationContext để quản lý.
     */
    /*
    Spring Boot đã tự tạo ra một Girl và trong quá trình tạo ra đó, nó truyền Outfit vào làm thuộc tính.

    Điều đặc biệt là các Bean được quản lý bên trong ApplicationContext đều là singleton.

    Outfit ở 2 đối tượng trên là một.

    Tất cả những Bean được quản lý trong ApplicationContext đều chỉ được tạo ra một lần duy nhất
    và khi có Class Girl yêu cầu @Autowired thì nó sẽ lấy đối tượng (outfit) có sẵn trong ApplicationContext để inject vào Girl.


     */
}

interface Outfit {
    void wear();
}

// Vậy làm sao Spring biết đâu là dependency? Chúng ta tới với khái niệm @Component
// @Component là một Annotation (chú thích) đánh dấu trên các Class để giúp Spring biết nó là một Bean.
    /*
     Đánh dấu class bằng @Component
     Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
     Và sẽ được Spring Boot quản lý
    */
    /*
    Có thể hiểu do Spring Boot đã tìm thấy hai bean phù hợp để inject vào 'Girl'.
    Do cả hai Bikini và Suit đều implements Outfit, mà Girl cần Outfit nên không biết nên chọn cái nào.
    */
    /*
    Giải pháp:
    Có hai cách giải quyết vấn đề này. Thứ nhất là dùng @Primary đánh dấu lên một bean.
    Khi đó bean này sẽ được ưu tiên chọn hơn, trong trường hợp có nhiều bean phù hợp trong context.
     */
@Component
@Primary
// Trong trường hợp bạn muốn mỗi lần sử dụng là một instance hoàn toàn mới. Thì hãy đánh dấu @Component đó bằng @Scope("prototype")
@Scope("prototype")
class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Mặc bikini");
    }
}

@Component
//@Primary
class Suit implements Outfit {
    @Override
    public void wear() {
        System.out.println("Mặc suit");
    }
}

@Component
class Girl {
    // Khi Spring Boot không biết chọn bean nào?
    // Khi tìm thấy nhiều bean phù hợp
    //Cũng lấy ví dụ trên, nếu chúng ta tạo thêm class VNEngine có chức năng tương tự ChinaEngine.


    // Cách 2 là chỉ định rõ tên bean (tên class) cụ thể được inject bằng @Qualifier.
    @Autowired
    public Outfit outfit;

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }


}

