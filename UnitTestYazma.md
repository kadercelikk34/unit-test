*****Test Aşamaları*****
-Unit Test (Birim Test)
-Integration Test (Entegrasyon Testi)
-Regression Test (Regresyon Testi)
-UI Test (Arayüz Testi)
-Performance Test (Performans  Testi)
-User Acceptance Test (Kullanıcı Kabul Testi)

****Unit Test****
-Yazılımın en küçük parcasını test eder.
-her parca bağımsız test edilir.Bir test metodunda  birden fazla seneryo test edilemez.
-Sadece bir seneryo test edilir
-Yazılımcı taraından yazılır.
-Dokumantasyon olarak kullanılanabilir.O parçanın ne iş yaptığı nasıl çalıştığını anlarız
-Çabuk geri bildirim alabilmek
-Kolay analiz ve refactoring
-Tüm hataları bulamaz
-Kullanılan adımalar Given-When-Then
-Tam otomatik çalışabilmeli (jenkins vs kullanılar çalıştırma)
-Hızlı çalışabilmeli ve çabuk sonuç vermelidir.Uzun sürebilecek işlemleri testlerimizde kullanmamalıyız
-Okunaklı , anlaşılabilir ve sürdürülebilir olmalıdır.
-Okunabilirlik için ; Metod isimleri metodla alakalı ve test metodu içeriği basit olmalıdır.
-Her zaman aynı sonuçu çıkarmalı.
-Test metod ismi test edilen seneryoyu yansıtmalı
  * test[özekkik ismi] (Örn: testPozitifSayılarıToplayıncaPozitifÇıkar)
  *sadece özellik ismi (Örn:pozitifSayılarıToplayıncaPozitifÇıkar)
  *should_beklenenDavranış_When_Koşul (Örn:should_PozitifSayıÇıkarır_When_PozitifSayıVerilirse)
  *When_Koşul_Expect_BeklenenDavranış (Örn:When_PozitifSayıVerilirse_Expect_PozitifSayıÇıkarır)
  *Given_ÖnHazırlık_When_Koşul_Then_BeklenenDavranış(Örn:given_BirHesapMakinesi_When_PozitifSayıerirlerse_Then_PozitifSayıÇıkartır)
  *Metod_Seneryo_Sonuç(Örn: topla_pozitifSayılar_Pozitif)
  *Metod_Sonuç_Seneryo(Örn: topla_Pozitif_pozitifSayılar)
  
-Test edilen parça diğer parçalardan bağımsız olmalıdır(mock,stup)
  stup -->Kullandığınız bağımlı parcanın yeğrine basitleştirlmiş bir sınıf kullanmak demektir.
  Dezavantajı ekstradan sınıf veya kod eklemek zorunda kalmanızdır.
  Stup kullanmak zahmetlidir.
  
  mock -->Çoğu zaman bu yöntem kullanılır.Bir çeşit proxy , sahte nesne demekdir ve orjinal nesneniz gibi davranır.
  içi bomboş olan ve sizin isteğiniz dorltusunda hareket eden bir nesne olur
-Unit testlerde metodların dosyada sıralanacağı şekilde kçalışıcağına dair garanti yokdur  
****Java Unit Test Araçları****
-JUnit
-Hamcrest
-AssertJ
-Mockito

  