package com.anysoftkeyboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anysoftkeyboard.keyboards.views.AnyKeyboardView;
import com.anysoftkeyboard.keyboards.views.CandidateView;
import com.menny.android.anysoftkeyboard.AskGradleTestRunner;
import com.menny.android.anysoftkeyboard.R;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.util.ServiceController;

@RunWith(AskGradleTestRunner.class)
public class AnySoftKeyboardTest {

    private ServiceController<AnySoftKeyboard> mAnySoftKeyboardUnderTest;

    @Before
    public void setUp() throws Exception {
        mAnySoftKeyboardUnderTest = Robolectric.buildService(AnySoftKeyboard.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSimpleLifeCycle() throws Exception {
        mAnySoftKeyboardUnderTest.attach().create().destroy();
    }

    @Test
    public void testOnCreateInputView() throws Exception {
        View mainKeyboardView = mAnySoftKeyboardUnderTest.attach().create().get().onCreateInputView();
        Assert.assertNotNull(mainKeyboardView);
        Assert.assertTrue(mainKeyboardView instanceof AnyKeyboardView);
    }

    @Test
    public void testOnCreateCandidatesView() throws Exception {
        View candidatesRootView = mAnySoftKeyboardUnderTest.attach().create().get().onCreateCandidatesView();
        Assert.assertNotNull(candidatesRootView);
        View candidateView = candidatesRootView.findViewById(R.id.candidates);
        Assert.assertNotNull(candidateView);
        Assert.assertTrue(candidateView instanceof CandidateView);
        View closeStripView = candidatesRootView.findViewById(R.id.close_suggestions_strip_icon);
        Assert.assertNotNull(closeStripView);
        Assert.assertTrue(closeStripView instanceof ImageView);
        View closeStripTextView = candidatesRootView.findViewById(R.id.close_suggestions_strip_text);
        Assert.assertNotNull(closeStripTextView);
        Assert.assertTrue(closeStripTextView instanceof TextView);
    }
/*
    @Test
    public void testCandidateViewCloseTextAnimation() throws Exception {
        View candidatesRootView = mAnySoftKeyboardUnderTest.attach().create().get().onCreateCandidatesView();
        View closeStripTextView = candidatesRootView.findViewById(R.id.close_suggestions_strip_text);
        View closeStripView = candidatesRootView.findViewById(R.id.close_suggestions_strip_icon);
        View.OnClickListener closeListener = Shadows.shadowOf(closeStripView).getOnClickListener();
        Assert.assertNotNull(closeListener);

        Assert.assertEquals(View.GONE, closeStripTextView.getVisibility());
        closeListener.onClick(closeStripView);
        Assert.assertEquals(View.VISIBLE, closeStripTextView.getVisibility());

        ShadowSystemClock.sleep(1999);
        Assert.assertEquals(View.VISIBLE, closeStripTextView.getVisibility());
        ShadowSystemClock.sleep(2);
        Assert.assertEquals(View.GONE, closeStripTextView.getVisibility());
    }

    @Test
    public void testCandidateViewCloseBehavior() throws Exception {
        View candidatesRootView = mAnySoftKeyboardUnderTest.attach().create().get().onCreateCandidatesView();
        View closeStripTextView = candidatesRootView.findViewById(R.id.close_suggestions_strip_text);
        View closeStripView = candidatesRootView.findViewById(R.id.close_suggestions_strip_icon);
        View.OnClickListener closeIconListener = Shadows.shadowOf(closeStripView).getOnClickListener();
        closeIconListener.onClick(closeStripView);
        View.OnClickListener closeListener = Shadows.shadowOf(closeStripTextView).getOnClickListener();

        closeIconListener.onClick(closeStripView);
        closeListener.onClick(closeStripTextView);

        Assert.assertEquals(View.GONE, closeStripTextView.getVisibility());
    }
*/
}