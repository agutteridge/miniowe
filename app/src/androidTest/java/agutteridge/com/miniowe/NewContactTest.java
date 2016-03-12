package agutteridge.com.miniowe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import android.util.Log;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewContactTest {
    private static final String TAG = NewContact.class.getSimpleName() + "DEBUG";

    @Rule
    public ActivityTestRule<NewContact> activityRule =
            new ActivityTestRule<>(NewContact.class);

    @Test
    public void testMinusOne() {
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.counter)).check(matches(withText("-1")));
    }

    @Test
    public void testPlusOne() {
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.counter)).check(matches(withText("1")));
    }

    @Test
    public void testMultiplePlusAndMinusClicks() {
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.counter)).check(matches(withText("-2")));
    }

}