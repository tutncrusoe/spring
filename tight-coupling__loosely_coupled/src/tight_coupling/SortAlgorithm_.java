package tight_coupling;

// Cách làm level 2:
interface SortAlgorithm_ {
    public void sort(int[] array);
}

class BubbleSortAlgorithm_ implements SortAlgorithm_ {

    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");
    }
}

class VeryComplexService_ {
    private SortAlgorithm_ sortAlgorithm;

    public VeryComplexService_() {
        sortAlgorithm = new BubbleSortAlgorithm_();
    }

    public void complexBusiness(int array[]) {
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }

    /*
    Với cách làm này, VeryComplexService sẽ chỉ quan hệ với một interface SortAlgorithm.
    Với cách này thì mỗi quan hệ giảm bớt sự liên kết, nhưng nó không thay đổi được việc thuật toán vẫn đang là BubbleSortAlgorithm.
     */
}



