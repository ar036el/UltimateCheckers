package el.arn.opencheckers.tools.purchase_manager

import android.content.Context
import el.arn.opencheckers.tools.purchase_manager.core.GenericPurchasesManager
import el.arn.opencheckers.tools.purchase_manager.core.PurchaseStatus

class PurchasesManager(
    context: Context
) : GenericPurchasesManager(context, setOf(noAdsSKU, fullVersionSKU))  {

    private companion object {
        const val noAdsSKU = "noAdsCrap"
        const val fullVersionSKU = "fullVersionCrap"
    }

    val noAds = getPurchasableItem(noAdsSKU)
    val fullVersion = getPurchasableItem(fullVersionSKU)

    val purchasedFullVersion get() = fullVersion.purchaseStatus == PurchaseStatus.Purchased
    val purchasedNoAds get() = noAds.purchaseStatus == PurchaseStatus.Purchased

}