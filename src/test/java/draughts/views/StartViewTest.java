package draughts.views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.StartController;

@RunWith(MockitoJUnitRunner.class)
public class StartViewTest {

    @Mock
    StartController startController;

    @InjectMocks
    StartView startView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteract(){
        startView.interact(startController);
        verify(startController).next();
    }

}