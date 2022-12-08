package com.example.component_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Bây giờ mình tạo ra một class BottleComponentAutowired
 * và có một thuộc tính là ShapeInterface.
 */

/**
 * Trong trường hợp bạn muốn mỗi lần sử dụng là một instance hoàn toàn mới.
 * Thì hãy đánh dấu @Component đó bằng @Scope("prototype")
 */
@Component
@Scope("prototype")
public class BottleComponentAutowired {

    /**
     * thuộc tính ShapeInterface của BottleComponentAutowired bởi Annotation @Autowired.
     * Điều này nói với Spring Boot hãy tự inject (tiêm) một instance của ShapeInterface
     * vào thuộc tính này khi khởi tạo BottleComponentAutowired.
     */
    @Autowired
    ShapeInterface shapeInterface;

    public BottleComponentAutowired(ShapeInterface shapeInterface) {
        this.shapeInterface = shapeInterface;
    }
}
