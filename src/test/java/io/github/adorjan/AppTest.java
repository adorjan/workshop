package io.github.adorjan;

import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {

    private App underTest;
    @Mock
    private Reader mockReader;
    @Mock
    private Writer mockWriter;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new App(mockReader, mockWriter);
    }

    @Test
    public void testDoRunShouldInvokeDependenciesInOrderWhenInvoked() {
        // GIVEN
        InOrder inOrder = Mockito.inOrder(mockReader, mockWriter);
        BDDMockito.willReturn("Hello").given(mockReader).read();
        // WHEN
        underTest.doRun();
        // THEN
        inOrder.verify(mockReader).read();
        inOrder.verify(mockWriter).write("Hello");
    }
}
