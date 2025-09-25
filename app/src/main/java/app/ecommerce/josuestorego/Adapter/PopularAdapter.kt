package app.ecommerce.josuestorego.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.ecommerce.josuestorego.Activity.DatailActivity
import app.ecommerce.josuestorego.Model.ItemModel
import app.ecommerce.josuestorego.databinding.ViewholderRecommendedBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

class PopularAdapter(
    private val items: MutableList<ItemModel>,
) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    fun updateDate(newData: List<ItemModel>) {
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder (val binding: ViewholderRecommendedBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.ViewHolder {
        val binding = ViewholderRecommendedBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.apply {
            titleTxt.text = item.title
            priceTxt.text = "$ ${item.price}"
            ratingTxt.text = item.rating.toString()

            Glide.with(holder.itemView.context)
                .load(item.picUrl.firstOrNull())
                .apply(RequestOptions().transform(CenterCrop()))
                .into(pic)

            root.setOnClickListener {
                val intent = Intent(holder.itemView.context, DatailActivity::class.java)
                intent.putExtra("object", item)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}