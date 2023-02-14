package com.example.di_ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Bây giờ giả sử, chúng ta định nghĩa trước toàn bộ các dependency có trong Project,
 * mô tả nó và tống nó vào 1 cái kho và giao cho một thằng tên là framework quản lý.
 * Bất kỳ các Class nào khi khởi tạo, nó cần dependency gì,
 * thì cái framework này sẽ tự tìm trong kho rồi inject vào đối tượng thay chúng ta.
 * sẽ tiện hơn phải không?
 */
@SpringBootApplication
public class DiIocApplication {

    @Autowired
    ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DiIocApplication.class, args);
    }

    /**
     * Khi đó, code chúng ta sẽ chỉ cần như này, để lấy ra 1 đối tượng:
     */
    public BottleDI getBeanOfBottleDI() {
        return context.getBean(BottleDI.class);
    }
}
