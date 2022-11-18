package de.dimitrikrylasov.wavejet.data

import de.dimitrikrylasov.wavejet.R
import de.dimitrikrylasov.wavejet.data.model.Feeds

class DataSource {
    private var _feedList = loadFeeds()
    val feedList:List<Feeds>
    get() = _feedList

    private fun loadFeeds(): List<Feeds> {
        return listOf(
            Feeds("1", R.drawable.image_13),
            Feeds("2", R.drawable.image_14),
            Feeds("3", R.drawable.image_15),
            Feeds("4",R.drawable.image_18),
            Feeds("5",R.drawable.image_19)
        )
    }
}