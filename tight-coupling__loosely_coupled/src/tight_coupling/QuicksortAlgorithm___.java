package tight_coupling;

// Cách làm level 3:
interface SortAlgorithm___ {
    public void sort(int[] array);
}

class BubbleSortAlgorithm__ implements SortAlgorithm___ {

    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");
    }
}

public class QuicksortAlgorithm___ implements SortAlgorithm___ {
    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật sx nhanh");
    }
}

class VeryComplexService___ {
    private SortAlgorithm___ sortAlgorithm;

    public VeryComplexService___(SortAlgorithm___ sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] array) {
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }
}

class Main {
    public static void main(String[] args) {
        SortAlgorithm___ bubbleSortAlgorithm = new BubbleSortAlgorithm__();
        SortAlgorithm___ quickSortAlgorithm = new QuicksortAlgorithm___();
        VeryComplexService___ business1 = new VeryComplexService___(bubbleSortAlgorithm);
        VeryComplexService___ business2 = new VeryComplexService___(quickSortAlgorithm);
    }

    /*
    Cách thứ ba này cũng là cách làm phổ biển nhất. Mối liên hệ giữa 2 Class đã "lỏng lẻo" hơn trước rất nhiều.
    'VeryComplexService' sẽ không quan tâm tới việc thuật toán sắp xép là gì nữa, mà chỉ cần tập trung vào nghiệp vụ.
    Còn SortAlgorithm sẽ được đưa vào từ bên ngoài tùy theo nhu cầu sử dụng.
     */
}