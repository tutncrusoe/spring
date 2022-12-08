package com.example.component_autowired;

import org.springframework.stereotype.Component;

interface ShapeInterface {
    void printShape();
}

/**
 * @Component là một Annotation (chú thích) đánh dấu trên các Class để giúp Spring biết nó là một Bean.
 * <p>
 * Đánh dấu class bằng @Component
 * Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 * Và sẽ được Spring Boot quản lý
 */
@Component
class RectangleImpl implements ShapeInterface {
    @Override
    public void printShape() {
        System.out.println("RectangleImpl");
    }
}

public class BottleComponent {

    private ShapeInterface shapeInterface;

    public BottleComponent() {
        this.shapeInterface = new RectangleImpl();
    }

    public BottleComponent(ShapeInterface shapeInterface) {
        this.shapeInterface = shapeInterface;
    }
}

/*
class Main {
    public static void main(String[] args) {
        // Tao ra mot doi tuong RectangleImpl
        ShapeInterface rectangle = new RectangleImpl();
//        ColorInterface color = new Red();
//        MaterialInterface material = new Plastic();

        BottleComponent bottleComponent = new BottleComponent(rectangle);
    }
*/
