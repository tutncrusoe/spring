package com.example.ioc_di_springbean.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @ApplicationScope Tao bean ngay tu dau, chia se tren pham vi application
 * va giai phong khi ung dung ket thuc.
 *
 * @SessionScope Tao bean ngay tu luc bat dau mot phien, chia se tren pham vi session
 * va giai phong khi session timeout.
 *
 * @RequestScope Tao bean ngay tu luc bat dau mot request, chia se tren pham vi request
 * va giai phong ngay khi request ket thuc.
 *
 * cart chi luu tru tam thoi nhung du lieu duoc chon. Vi du:
 * 1. Chua cac mat hang da~ chon (web ban hang).
 * 2. Chua cac khoa hoc da~ chon (dao` tao).
 * 3. Chua cac dich vu cua mot tour tu chon (du lich).
 *
 * Tuy vao truong hop:
 * 1. HttpSession (luu phia server): ket thuc phien se bi giai phong.
 *
 * 2. sessionStorage(luu phia client): ket thuc phien se bi giai phong.
 * Can phai gui len server khi dat hang.
 *
 * 3. Database: duy tri cho den khi xoa. Tuy nhien can tinh den giai phap
 * thu gom rac.
 *
 * 4. localStorage(luu phia client): duy tri cho den khi xoa,
 * chi xem lai tren cung` mot may. Can phai gui len server khi order.
 *
 * 5. Cookie(luu phia client va tu dong truyen voi server khi co request): Duy tri
 * theo thoi han, kich thuoc luu tru rat han che.
 */
@SessionScope
@Service("cart")
public class ShoppingCart {
}
