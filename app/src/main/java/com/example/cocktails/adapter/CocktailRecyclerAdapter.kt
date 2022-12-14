package com.example.cocktails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.R
import com.example.cocktails.model.Cocktail
import com.example.cocktails.util.download
import com.example.cocktails.util.makePlaceholder
import kotlinx.android.synthetic.main.cocktails_recycler_row.view.*

class CocktailRecyclerAdapter(val cocktailList : ArrayList<Cocktail>) : RecyclerView.Adapter<CocktailRecyclerAdapter.CocktailViewHolder>() {
    class CocktailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cocktails_recycler_row,parent,false)
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.itemView.txtNameRow.text = cocktailList.get(position).name
        holder.itemView.txtTypeRow.text = cocktailList.get(position).type

        // TO DO: Action'dan action'a geçiş (detaile gitmek) için buraya kod eklenecek
        // holder.itemView.setOnClickListener{}

        holder.itemView.imgCocktailRow.download(cocktailList.get(position).image, makePlaceholder(holder.itemView.context))
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    fun updateCocktailList(newCocktailList: List<Cocktail>){
        cocktailList.clear()
        cocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }
}