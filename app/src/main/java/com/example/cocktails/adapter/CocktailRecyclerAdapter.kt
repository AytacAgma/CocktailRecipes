package com.example.cocktails.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat.startActivity
//import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.R
import com.example.cocktails.model.Cocktail
import com.example.cocktails.util.show
import com.example.cocktails.util.makePlaceholder
import com.example.cocktails.view.CocktailDetails
import kotlinx.android.synthetic.main.cocktails_recycler_row.view.*
import java.util.*
import kotlin.collections.ArrayList

class CocktailRecyclerAdapter(val cocktailList: ArrayList<Cocktail>) :
    RecyclerView.Adapter<CocktailRecyclerAdapter.CocktailViewHolder>(), Filterable {
    class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    cocktailFilterList = cocktailList
                } else {
                    val resultList = ArrayList<Cocktail>()
                    for (row in cocktailList) {
                        row.name?.let{
                            if (it.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))
                            ) {
                                resultList.add(row)
                            }
                        }
                    }
                    cocktailFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = cocktailFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                cocktailFilterList = results?.values as ArrayList<Cocktail>
                notifyDataSetChanged()
            }
        }
    }

    var cocktailFilterList = ArrayList<Cocktail>()

    init {
        cocktailFilterList = cocktailList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cocktails_recycler_row, parent, false)
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.itemView.txtNameRow.text = cocktailFilterList[position].name
        holder.itemView.txtTypeRow.text = cocktailFilterList[position].type
        holder.itemView.imgCocktailRow.show(
            cocktailFilterList[position].image,
            makePlaceholder(holder.itemView.context)
        )

        // Action'dan action'a geçiş (detaile gitmek) için buraya kod eklendi
        holder.itemView.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.cocktailDetails)
            val intent = Intent(it.context, CocktailDetails::class.java)
                .putExtra("id", cocktailFilterList[position].id)
                .putExtra("name", cocktailFilterList[position].name)
                .putExtra("type", cocktailFilterList[position].type)
                .putExtra("image", cocktailFilterList[position].image)
                .putExtra("ingredient1", cocktailFilterList[position].ingredient1)
                .putExtra("ingredient2", cocktailFilterList[position].ingredient2)
                .putExtra("ingredient3", cocktailFilterList[position].ingredient3)
                .putExtra("ingredient4", cocktailFilterList[position].ingredient4)
                .putExtra("measure1", cocktailFilterList[position].measure1)
                .putExtra("measure2", cocktailFilterList[position].measure2)
                .putExtra("measure3", cocktailFilterList[position].measure3)
                .putExtra("measure4", cocktailFilterList[position].measure4)
                .putExtra("howTo", cocktailFilterList[position].howTo)
            startActivity(
                it.context,
                intent,
                Bundle.EMPTY
            ) //TO DO: startActivity putExtra yerine Bundle ile toplu göndermeye bakılacak
        }
    }

    override fun getItemCount(): Int {
        return cocktailFilterList.size
    }

    fun updateCocktailList(newCocktailList: List<Cocktail>) {
        cocktailList.clear()
        cocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }
}