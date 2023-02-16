package com.example.di_ioc_bean.DI;
// Spring」Giải thích Dependency Injection (DI) và IoC
// https://viblo.asia/p/springgiai-thich-dependency-injection-di-va-ioc-bang-ngoc-trinh-naQZRW3Alvx

/*
Heyzau, chào tất cả các bạn, hôm nay mình sẽ chia sẻ về 2 khái niệm gây nhức nhối và thương nhớ cho rất nhiều developer
, Để làm việc được với Spring và hệ sinh thái quanh nó, thì việc đầu tiên, tiên quyết, duy nhất bạn cần làm đó là thấu hiểu định nghĩa của 2 cái này.

Vậy chúng nó là cái gì, chúng ta sẽ đi vào chi tiết nhé.
 */
class Bikini {
}

public class Girl {
    private Bikini outfit; // mỗi cô gái sẽ có một bộ bikini khi ra ngoài

    public Girl() {
        outfit = new Bikini(); // Khi bạn tạo ra 1 cô gái, bạn cho cô ta mặc Bikini chẳng hạn
    }

    /*
Trước hết, qua đoạn code này, bạn sẽ thấy là khi bạn tạo ra một Girl
, bạn sẽ tạo ra thêm 1 bộ Bikini đi kèm với cô gái đó. Lúc này, Bikini tồn tại mang ý nghĩa là dependency (phụ thuộc) của Girl.

Khi khởi tạo thuộc tính như này, bạn vô tình tạo ra một điểm thắt nút trong chương trình của mình
, giả sử, Girl muốn mặc một bộ Váy + Áo thun hở rốn hay không mặc gì thì sao? Bạn sẽ phải thay class Bikini thành SkirtWithTshirt(Váy với áo T-shirt) hay Naked (Trần như nhộng) ư?

Hay nguy hiểm hơn, bộ đồ Bikini bị hỏng? (code lớp Bikini không hoạt động?) nó sẽ ảnh hưởng trực tiếp tới Girl.
*/
    /**
     * Vấn đề là ở đó, nguyên tắc là:
     * Các Class không nên phụ thuộc vào các kế thừa cấp thấp, mà nên phụ thuộc vào Abstraction (lớp trừu tượng). (co nghia la: Girl khong nen phu thuoc vao Bikini (cap thap), ma nen phu thuoc vao interface Outfit).
     */
}

// Nghe hơi khó hiểu. Bây giờ mình thay đoạn code như này:
interface outfit {
    public void wear();
}

// Một object cấp thấp, implement của outfit
class bikini implements outfit {
    public void wear() {
        System.out.println("Đã mặc Bikini");
    }
}

// Bây giờ Girl chỉ phụ thuộc vào Outfit. nếu muốn thay đổi đồ của cô gái, chúng ta chỉ cần cho Outfit một thể hiện mới.
class girl {
    private outfit outfit;

    public girl() {
        outfit = new bikini();
    }

    /*
    Tới đây, chúng ta mới chỉ Abtract hóa thuộc tính của Girl mà thôi, còn thực tế, Girl vẫn đang bị gắn với một bộ Bikini duy nhất. Vậy muốn thay đồ cho cô gái, bạn phải làm như nào.
     */
}

// Phải sửa code thêm chút nữa:
interface Outfit_ {
    public void wear();
}

class Bikini_ implements Outfit_ {
    public void wear() {
        System.out.println("Đã mặc Bikini");
    }
}

class Girl_ {
    private Outfit_ outfit;

    public Girl_(Outfit_ anything) {
        this.outfit = anything; // Tạo ra một cô gái, với một món đồ tùy biến
        // Không bị phụ thuộc quá nhiều vào thời điểm khởi tạo, hay code.
    }
}

class Main_ {
    public static void main(String[] args) {
        Outfit_ bikini_ = new Bikini_(); // Tạo ra đối tượng Bikini ở ngoài đối tượng
        Girl_ girl_ = new Girl_(bikini_); // Mặc nó vào cho cô gái khi tạo ra cô ấy.
    }

    /*
    Với đoạn code ở trên, chúng ta đã gần như tách được Bikini ra hoàn toàn khỏi Girl.
    điều này làm giảm sự phụ thuộc giữa Girl và Bikini. Mà tăng tính tùy biến, linh hoạt cho code.

Bây giờ Girl sẽ hoạt động với Outfit mà thôi. Và Outfit ở đâu ra? Chúng ta tạo ra và đưa nó vào (Inject) cô gái Girl.
     */
    /**
     * Dependency Injection là việc các Object nên phụ thuộc vào các Abstract Class và thể hiện chi tiết của nó sẽ được Inject vào đối tượng lúc runtime. (co nghia la bikini tao truoc, sau do inject vao girl)
     */

    /*
    - Bây giờ muốn Girl mặc gì khác, bạn chỉ cần tạo một Class kế thừa Outfit và Inject (dịch là Tiêm vào cũng được) nó vào Girl là xong!

    - Các cách để Inject dependency vào một đối tượng có thể kể đến như sau:

Constructor Injection: Cái này chính là ví dụ của mình, tiêm dependency ngay vào Contructor cho tiện.

Setter Injection: Ồ, sao không chứ 😗 chúng ta học về Setter từ những bài học vỡ lòng rồi, quá hợp lý. Xài girl.setOutfit(new Naked()) 😈

Interface Injection: Mỗi Class muốn inject cái gì, thì phải implement một Interface có chứa một hàm inject(xx) (Gần như thay thế cho setter ý bạn). Rồi bạn muốn inject gì đó thì gọi cái hàm inject(xx) ra. Cách này hơi dài và khó cho người mới.
     */
}