package de.dimitrikrylasov.wavejet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.dimitrikrylasov.wavejet.R
import de.dimitrikrylasov.wavejet.data.model.Events


class ItemAdapter(
    private val dataset: List<Events>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


        class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

            val image: ImageView = view.findViewById(R.id.dashboard_feed_img)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout  = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.image.load(item.banner)
    }

    override fun getItemCount(): Int {
      return dataset.size
    }

}