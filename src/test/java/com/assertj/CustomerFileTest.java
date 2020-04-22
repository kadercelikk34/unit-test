package com.assertj;

import com.unittest.customer.exception.MailServerUnavaibleException;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class CustomerFileTest {
    @Test
    public void testFiles() throws Exception{
        File file = new File("/Users/kader.celik/Desktop/SpringProject/unit-test/src/test/resources/test.txt");
        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("txt")
                .hasName("test.txt");

        assertThat(contentOf(file))
                .startsWith("Lorem");
    }

    @Test
    public void testException() throws Exception {
        Exception exception = new MailServerUnavaibleException("this is a test");
        assertThat(exception)
                .hasMessage("this is a test")
                .isInstanceOf(MailServerUnavaibleException.class)
                .hasMessageContaining("is a");
    }
}
