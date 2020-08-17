package el.arn.opencheckers.dialogs

import android.app.Activity
import android.content.Context
import el.arn.opencheckers.AppRoot
import el.arn.opencheckers.tools.preferences_managers.PreferencesManager

interface RateUsDialogInvoker {
    fun tryToInvokeDialog(activity: Activity): RateUsDialog?
    fun invokeDialogNow(activity: Activity): RateUsDialog
    fun dontInvokeDialogAgain()
    fun invokeDialogLater(feedbackState: RateUsDialog.FeedbackState? = null)
}

class RateUsDialogInvokerImpl(appRoot: AppRoot) : RateUsDialogInvoker {
    object InvokeAfterXCalls {
        const val FIRST_TIME = 2
        const val FEEDBACK_IS_NEUTRAL = 3
        const val FEEDBACK_IS_NEGATIVE = 5
        const val FEEDBACK_IS_POSITIVE = 2
        val MAX_VALUE = listOf(FEEDBACK_IS_NEUTRAL, FEEDBACK_IS_POSITIVE, FEEDBACK_IS_NEGATIVE).max()!!
    }

    private val purchasesPrefsManager = object: PreferencesManager(appRoot.getSharedPreferences("rateUsDialog", Context.MODE_PRIVATE)) {
        val callsUntilInvocation = createIntPref("callsUntilPrompt", 0..InvokeAfterXCalls.MAX_VALUE, InvokeAfterXCalls.FIRST_TIME)
    }

    override fun tryToInvokeDialog(activity: Activity): RateUsDialog? {
        if (purchasesPrefsManager.callsUntilInvocation.value > 0) {
            purchasesPrefsManager.callsUntilInvocation.value--
            if (purchasesPrefsManager.callsUntilInvocation.value == 0) {
                return invokeDialogNow(activity)
            }
        }
        return null
    }

    override fun invokeDialogNow(activity: Activity): RateUsDialog {
        return RateUsDialog(this, activity)
    }

    override fun dontInvokeDialogAgain() {
        purchasesPrefsManager.callsUntilInvocation.value = 0
    }

    override fun invokeDialogLater(feedbackState: RateUsDialog.FeedbackState?) {
        purchasesPrefsManager.callsUntilInvocation.value =
            when(feedbackState) {
                RateUsDialog.FeedbackState.NeutralFeedbackOrUnspecified, null -> InvokeAfterXCalls.FEEDBACK_IS_NEUTRAL
                RateUsDialog.FeedbackState.NegativeFeedback -> InvokeAfterXCalls.FEEDBACK_IS_NEGATIVE
                RateUsDialog.FeedbackState.PositiveFeedback -> InvokeAfterXCalls.FEEDBACK_IS_POSITIVE
            }
    }

}