package neth.iecal.curbox

import android.app.Activity
import android.app.Application
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

class WatermarkCallbacks : Application.ActivityLifecycleCallbacks {

    override fun onActivityResumed(activity: Activity) {
        val root = activity.findViewById<ViewGroup>(android.R.id.content) ?: return
        if (root.findViewWithTag<View>(TAG) != null) return

        val d = activity.resources.displayMetrics.density
        val label = TextView(activity).apply {
            tag = TAG
            text = "powered by mood ahmad"
            textSize = 10f
            alpha = 0.45f
            letterSpacing = 0.08f
            setTypeface(Typeface.SERIF, Typeface.ITALIC)
            setTextColor(0xFF808080.toInt())
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }

        val lp = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            Gravity.BOTTOM or Gravity.END
        ).apply {
            marginEnd = (12 * d).toInt()
            bottomMargin = (76 * d).toInt()
        }

        root.addView(label, lp)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}

    private companion object {
        const val TAG = "mood_ahmad_watermark"
    }
}
