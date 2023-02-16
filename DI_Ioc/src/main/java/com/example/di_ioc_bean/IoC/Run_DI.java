package com.example.di_ioc_bean.IoC;

//import com.example.di_ioc.DI.Bikini_;
//import com.example.di_ioc.DI.Girl_;
//import com.example.di_ioc.DI.Outfit_;

/*
Inversion of Control
Dependency Injection giúp chúng ta dễ dàng mở rộng code và giảm sự phụ thuộc giữa các dependency với nhau.
Tuy nhiên, lúc này, khi code bạn sẽ phải kiêm thêm nhiệm vụ Inject dependency (tiêm sự phụ thuộc).
Thử tưởng tượng một Class có hàng chục dependency thì bạn sẽ phải tự tay inject từng ý cái.
Việc này lại dẫn tới khó khăn trong việc code, quản lý code và dependency.
 */
class Main {
    //Outfit_ bikini_ = new Bikini_();
    //Accessories_ gucci_ = new GucciAccessories_();
    //HairStyle_ hair_ = new KoreanHairStyle_();
    //...
    //Girl_ ngocTrinh = new Girl_(bikini_, gucci_, hair_);

    /*
    Giá như lúc này có thằng làm hộ được chúng ta việc này thì tốt biết mấy.

Bây giờ giả sử, chúng ta định nghĩa trước toàn bộ các dependency có trong Project, mô tả nó và tống nó vào 1 cái kho và giao cho một thằng tên là framework quản lý.
Bất kỳ các Class nào khi khởi tạo, nó cần dependency gì, thì cái framework này sẽ tự tìm trong kho rồi inject vào đối tượng thay chúng ta. sẽ tiện hơn phải không?
     */
}

// https://images.viblo.asia/full/affc9432-a35e-4360-ad9b-b5c09e2fdd29.jpg
//That it, chính nó, đó cũng chính là nguyên lý chính của Inversion of Control (IOC) - Đảo chiều sự điều khiển.

