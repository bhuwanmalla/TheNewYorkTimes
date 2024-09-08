package bhuwan.example.thenewyorktimes.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bhuwan.example.thenewyorktimes.R
import bhuwan.Result
import bhuwan.example.thenewyorktimes.WebDesignActivity
import com.bumptech.glide.Glide

class TopStoriesAdapter(
    private val context: Context,
    private val stories: MutableList<Result>
) : RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoriesViewHolder {
        val newView = LayoutInflater.from(context).inflate(R.layout.articles_design, parent, false)
        return TopStoriesViewHolder(newView)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: TopStoriesViewHolder, position: Int) {
        holder.bind(stories[position])
    }

    inner class TopStoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val title: TextView = itemView.findViewById(R.id.leadParagraphTV)

        fun bind(story: Result) {
            title.text = story.title

            val multimedia = story.multimedia
            if (!multimedia.isNullOrEmpty()) {
                val imageUrl = multimedia[0].url
                if (!imageUrl.isNullOrEmpty()) {
                    Glide.with(itemView.context)
                        .load(imageUrl)
                        .error(R.drawable.newspaper_free_download)
                        .placeholder(R.drawable.newspaper_free_download)
                        .into(image)
                } else {
                    image.setImageURI(null)
                }
            } else {
                image.setImageURI(null)
            }

            itemView.setOnClickListener {
                val webUrl = story.url
                if (!webUrl.isNullOrEmpty()){
                    val intent = Intent(context, WebDesignActivity::class.java)
                    intent.putExtra("web_url", webUrl)
                    context.startActivity(intent)
                }
            }
        }
    }
}
