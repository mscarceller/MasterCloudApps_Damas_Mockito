package draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    YesNoDialog yesNoDialog;

    @InjectMocks
    ResumeView resumeView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGivenResumeViewWhenUserWantsNewGameThenNewGame(){
        when(yesNoDialog.read("¿Queréis jugar otra")).thenReturn(true);
        resumeView.interact(resumeController);
        verify(resumeController).isNewGame(true);
    }

    @Test
    public void testGivenResumeViewWhenUserExitThenNextStateExit(){
        when(yesNoDialog.read("¿Queréis jugar otra")).thenReturn(false);
        resumeView.interact(resumeController);
        verify(resumeController).isNewGame(false);
    }

}