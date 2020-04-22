****JUnit****
- En cok kullanılan java test frameworküdür.Java sınıflarıyla test ederiz.
 @BeforeClass :Test başladığındaönce bu anatasyonun eklendiği classs çağrılır.Her sınıf için sadece 1 kere çağrılır    
 @Before  : Her test metodu çağrılmadan önce 1 kere çağrılır.
 @Test
 @After : Her Test metodundan sonra çağrılır.
 @AfterClass : Metodlar bitip test sınıfı sona ermeden önce çağrılır.
-Assertions : İşlemi yaptıkdan sonra sonucun doğru olup olmadığını test etmek için kullanılır.
-Parametreler;
 @RunWith(Parameterized.class)
 @Parameters(En çok kullandığım ve en kolay :))
 @JUnitParams @Parameters

-Hata Test Etme
 try catch
 @Test - excepted
 @Rule
 CatchException Framework
 
-Suite(Gruplayarak test etme)
-Ignore (Kullanmak istemediğimiz metodları Devre dışı bırakmak için kullanılır.)

  