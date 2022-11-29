package com.example.ioc_di_springbean.configuration;

import com.example.ioc_di_springbean.model.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {

    /**
     * Phuong thuc getCompany() duoc chu' thich' boi @Bean
     * ben trong lop duoc chu' thich' boi @Configuration vi` vay
     * doi tuong tra ve cua phuong thuc nay` duoc Spring nap vao` Spring Beans.
     */

    /**
     * @SessionScope Tao bean ngay tu luc bat dau mot phien, chia se tren pham vi session
     * va giai phong khi session timeout.
     *
     * session.getAttribute("scopedTarget.cart")
     * ${sessionScope['scopedTarget.cart']}
     */
    @SessionScope
    @Bean("cart")
    @Primary
    public Company getCompanyName() {
        Company company = new Company();
        company.setName("tutncrusoe's Company");
        return company;
    }

    /**
     * * Neu co nhieu` hon mot Spring Bean co kieu phu` hop voi bien thi` he thong se bao loi.
     * *
     * * Giai quyet van de nay` co 2 cach:
     * * C1: Cau hinh @Bean voi @Primary de bao cho he thong biet do' la` bean chinh.
     * * C2: Dat id cho bean va` su dung @Qualifier(id) ben canh. @Autowired
     *
     * @Autowired se uu tien lien ket voi @Bean nay`.
     */
    @Bean("bean2")
    public Company getCompanyAddress() {
        return new Company();
    }


}
