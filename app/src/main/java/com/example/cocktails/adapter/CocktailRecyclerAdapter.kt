package com.example.cocktails.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
//import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.R
import com.example.cocktails.model.Cocktail
import com.example.cocktails.util.show
import com.example.cocktails.util.makePlaceholder
import com.example.cocktails.view.CocktailDetails
import kotlinx.android.synthetic.main.cocktails_recycler_row.view.*

class CocktailRecyclerAdapter(val cocktailList : ArrayList<Cocktail>) : RecyclerView.Adapter<CocktailRecyclerAdapter.CocktailViewHolder>() {
    class CocktailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    var cocktailFilterList = ArrayList<Cocktail>()

    init {
        cocktailFilterList = cocktailList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cocktails_recycler_row,parent,false)
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.itemView.txtNameRow.text = cocktailList.get(position).name
        holder.itemView.txtTypeRow.text = cocktailList.get(position).type
        holder.itemView.imgCocktailRow.show(cocktailList.get(position).image, makePlaceholder(holder.itemView.context))

        // Action'dan action'a geçiş (detaile gitmek) için buraya kod eklendi
        holder.itemView.setOnClickListener{
            //Navigation.findNavController(it).navigate(R.id.cocktailDetails)
            val intent = Intent(it.context,CocktailDetails::class.java)
                .putExtra("id",cocktailList.get(position).id)
                .putExtra("name",cocktailList.get(position).name)
                .putExtra("type",cocktailList.get(position).type)
                .putExtra("image",cocktailList.get(position).image)
                .putExtra("ingredient1",cocktailList.get(position).ingredient1)
                .putExtra("ingredient2",cocktailList.get(position).ingredient2)
                .putExtra("ingredient3",cocktailList.get(position).ingredient3)
                .putExtra("ingredient4",cocktailList.get(position).ingredient4)
                .putExtra("measure1",cocktailList.get(position).measure1)
                .putExtra("measure2",cocktailList.get(position).measure2)
                .putExtra("measure3",cocktailList.get(position).measure3)
                .putExtra("measure4",cocktailList.get(position).measure4)
                .putExtra("howTo",cocktailList.get(position).howTo)
            startActivity(it.context, intent, Bundle.EMPTY) //TO DO: startActivity putExtra yerine Bundle ile toplu göndermeye bakılacak
        }
    }

    override fun getItemCount(): Int {
        return cocktailFilterList.size
    }

    fun updateCocktailList(newCocktailList: List<Cocktail>){
        cocktailList.clear()
        cocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }
}