package io.github.adorjan;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.MockitoAnnotations.initMocks;

import org.mockito.InOrder;
import org.mockito.Mock;
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
        initMocks(this);
        underTest = new App(mockReader, mockWriter);
    }

    @Test
    public void testDoRunShouldInvokeDependenciesInOrderWhenInvoked() {
        // GIVEN
        InOrder inOrder = inOrder(mockReader, mockWriter);
        willReturn("Hello").given(mockReader).read();
        // WHEN
        underTest.doRun();
        // THEN
        inOrder.verify(mockReader).read();
        inOrder.verify(mockWriter).write("Hello");
    }
}
