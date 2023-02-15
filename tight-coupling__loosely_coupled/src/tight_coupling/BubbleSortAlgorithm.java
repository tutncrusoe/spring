package tight_coupling;
// https://viblo.asia/p/khai-niem-tight-coupling-lien-ket-rang-buoc-va-cach-loosely-coupled-63vKjVERK2R
/*
- tight-coupling hay "liên kết ràng buộc" là một khái niệm trong Java ám chỉ việc mối quan hệ giữa các Class quá chặt chẽ. Khi yêu cầu thay đổi logic hay một class bị lỗi sẽ dẫn tới ảnh hưởng tới toàn bộ các Class khác.

- loosely-coupled là cách ám chỉ việc làm giảm bớt sự phụ thuộc giữa các Class với nhau.
 */

// Cách code level 1
class BubbleSortAlgorithm {
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");

    }
}

class VeryComplexService {
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public VeryComplexService() {
    }

    public void complexBusiness(int[] array) {
        bubbleSortAlgorithm.sort(array);
        // TODO: more logic here
    }

    /*
    - Với cách làm ở trên, VeryComplexService đã hoàn thiện được nhiệm vụ
    , tuy nhiên, khi có yêu cầu thay đổi thuật toán sắp xếp sang QuickSort thì nghe vẻ chúng ta sẽ phải sửa lại hoàn toàn cả 2 Class trên.

    - Ngoài ra BubbleSortAlgorithm sẽ chỉ tồn tại nếu VeryComplexService tồn tại
    , vì VeryComplexService tạo đối tượng BubbleSortAlgorithm bên trong nó (hay nói cách khác là sự sống chết của BubbleSortAlgorithm sẽ do VeryComplexService quyết định)
    , theo như cách implement này, nó là liên kết rất chặt với nhau.
     */
}

