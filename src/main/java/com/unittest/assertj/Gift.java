package com.unittest.assertj;

import lombok.*;

/*Getter sınıf ve değişken bazında ekleyebilir.
 sınıf bazında eklenirse  tüm sınıfdaki değişkenlere getter metodu ekler*/
//@Getter
//@Setter
//@ToString
@Data //İçerisinde get ,set equals, hascode, tostring vb bircok anatosyonu içinde barındırır
@AllArgsConstructor //sınıfdaki tüm değişkenlerin kullanıldığı bir Constructor verir
@NoArgsConstructor //default Constructor verir
@Builder //Builder desing pattern kullanılarak sınıfı yapılandırır.
public class Gift {
    private String name;

}
