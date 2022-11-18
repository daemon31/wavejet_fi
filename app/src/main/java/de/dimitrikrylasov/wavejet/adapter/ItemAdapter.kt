package de.dimitrikrylasov.wavejet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.dimitrikrylasov.wavejet.R
import de.dimitrikrylasov.wavejet.data.model.Feeds
import io.grpc.Context


class ItemAdapter (
    private val dataset: List<Feeds>,
    private val context: Context
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


        inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var feedImage: ImageView = itemView.findViewById(R.id.dashboard_feed_rcv)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout  = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.feedImage.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
      return dataset.size
    }

}