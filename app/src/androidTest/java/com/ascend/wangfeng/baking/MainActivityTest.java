package com.ascend.wangfeng.baking;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * 测试从开始界面到点击到无视频选项
     * @throws InterruptedException
     */
    @Test
    public void onClickNoVedio() throws InterruptedException {
        Thread.sleep(3000);
        onView(withText("Brownies")).perform(click());
        Thread.sleep(1000);
        onView(withText("Starting prep")).perform(click());
        onView(withText(R.string.no_vedio)).check(matches(isDisplayed()));

    }

    /**
     * 测试完整流程至点击 FloatingActionButton 出现ingredient弹框
     * @throws InterruptedException
     */
    @Test
    public void onClickFinished() throws InterruptedException {
        Thread.sleep(3000);
        onView(withText("Brownies")).perform(click());
        Thread.sleep(1000);
        onView(withText("Melt butter and bittersweet chocolate.")).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.ingredient)).perform(click());
        onView(withId(R.id.list_ingredient)).check(matches(isDisplayed()));
    }
}
