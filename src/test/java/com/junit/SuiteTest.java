package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EasyParameterTest.class,
        AssertTest.class,
        ParameterTest.class,
        LifeCycleTest.class
})
//Herhangi bir metod eklememize gerek yok.Verdiğimiz sınıf sırasına göre çalıştırır.
public class SuiteTest {
}
