package com.unittest.customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/*unit testlerde test ettiğimiz parca diğer parçalardan tamamen bağımsız olmalıdır.
Testimiz her yerde çalışabilir olması ve hiçbirşeye gereksin,m duymamması gerekiyor.
Bunu gercekleştirmek için mock veya stup kullanmamız gerekir */
public class CustomerServiceTest {
    private CustomerService customerService;
    private CustomerRepositoryStup customerRepository = new CustomerRepositoryStup();;
    private NotificationService notificationService;
    //Her testimizden önce yapılması istediğimiz şeyleri setUp metodu içine yazarız.
    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
        //customerRepository = new CustomerRepository();
       // notificationService = new NotificationService();
       // customerRepository = Mockito.mock(CustomerRepository.class);
        notificationService = Mockito.mock( NotificationService.class);
        customerService.setCustomerRepository(customerRepository);
        customerService.setNotificationService(notificationService);

    }
    //Her test metodunun çalıştırılmasından sonra çalıştırılır.
    @After
    public void after() {
        customerRepository.deletedAll();
    }
    @Test
    public void testCustomerSave(){
        Customer customer = new Customer(1234);
        customerService.handleNewCustomer("kader","k@gmail.com");

        //kontrol etmemiz gerekiyor ??
       // Mockito.verify(customerRepository).save(customer);
        customerRepository.save(customer);
       // assertTrue(customerRepository.getCustomerList().containsValue(customer));
        assertEquals(customer, customerRepository.search(customer.getId()));
        Mockito.verify(notificationService).newCustomerMailSend("kader","k@gmail.com");

    }
    @Test
    public void testCustomerDeleted() throws Exception{
        /*bir test metodu içerisinden başka bir test metodunu çağırmak yanlış bir kullanımdır.
        Cünkü kaydet metodundaki her değişiklik sil metodunu etkilemekdedir. */
        //testCustomerSave();
        //yeni bir müşteri ekleyerek her iki etodunda birbirinden bağımsız çalışması sağlandı
        customerRepository.save(new Customer(1234));
        customerRepository.deleted(1234);
        assertNull(customerRepository.search(1234));
    }

}