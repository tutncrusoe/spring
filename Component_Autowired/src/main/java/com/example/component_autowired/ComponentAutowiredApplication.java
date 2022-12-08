package com.example.component_autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * nhiệm vụ chính của Spring là tạo ra một cái Container chứa các Dependency cho chúng ta.
 * <p>
 * SpringApplication.run(App.class, args) chính là câu lệnh để tạo ra container.
 * Sau đó nó tìm toàn bộ các dependency trong project của bạn và đưa vào đó.
 *
 * https://viblo.asia/p/spring-boot-1-huong-dan-atcomponent-va-atautowired-E375zXvJZGW
 */
@SpringBootApplication
public class ComponentAutowiredApplication {

    public static void main(String[] args) {
        /**
         * Spring đặt tên cho container là ApplicationContext
         *
         * ApplicationContext chứa toàn bộ dependency trong project.
         *
         * và đặt tên cho các dependency là Bean
         */

        // ApplicationContext chính là container, chứa toàn bộ các Bean
        ApplicationContext context = SpringApplication.run(ComponentAutowiredApplication.class, args);

        // Component
        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.
        // Lấy Bean ra bằng cách
        RectangleImpl rectangle = context.getBean(RectangleImpl.class);

        // In ra để xem thử nó là gì
        System.out.println("Instance: " + rectangle);
        // xài hàm print()
        rectangle.printShape();

        // Autowired
        BottleComponentAutowired bottle = context.getBean(BottleComponentAutowired.class);

        System.out.println("Bottle Instance: " + bottle);

        /**
         * Điều đặc biệt là các Bean được quản lý bên trong ApplicationContext đều là singleton.
         * Bạn chắc đã để ý điều này từ các Output ở phía trên.
         */
        // shape ở 2 đối tượng trên là một.
        System.out.println("Bottle Shape: " + bottle.shapeInterface);

        bottle.shapeInterface.printShape();

        /**
         * Tất cả những Bean được quản lý trong ApplicationContext đều chỉ được tạo ra một lần duy nhất
         * và khi có Class yêu cầu @Autowired thì nó sẽ lấy đối tượng có sẵn trong ApplicationContext để inject vào.
         */

    }

}
