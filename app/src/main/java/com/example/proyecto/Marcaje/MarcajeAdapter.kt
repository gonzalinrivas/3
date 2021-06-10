package com.example.proyecto.Marcaje

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.proyecto.R
import com.example.proyecto.databinding.ItemMarcajeBinding

class MarcajesAdapter(
    private var stores: MutableList<MarcajesEntity>,
    private var listener: OnClickListener
) :
    RecyclerView.Adapter<MarcajesAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_marcaje, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)


        //CAMBIAR LISTADO
        with(holder) {
            setListener(store)
            binding.tvName.text = store.name
            binding.cbFavorite.isChecked = store.isFavorite
            binding.tvMatricula.text = store.matricula
            // binding.tvTipoActividadListado.text=store.tipoActividad


            Glide.with(mContext)
                .load(store.name)//IMGURL
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int = stores.size


    fun add(marcajesEntity: MarcajesEntity) {
        if (!stores.contains(marcajesEntity)) {
            stores.add(marcajesEntity)
            notifyItemInserted(stores.size - 1)
        }
    }

    fun setMarcajes(darMarcajes: MutableList<MarcajesEntity>) {
        this.stores = darMarcajes
        notifyDataSetChanged()

    }

    fun update(marcajesEntity: MarcajesEntity) {
        val index = stores.indexOf(marcajesEntity)
        if (index != -1) {
            stores.set(index, marcajesEntity)
            notifyItemChanged(index)
        }

    }

    fun delete(marcajesEntity: MarcajesEntity) {
        val index = stores.indexOf(marcajesEntity)
        if (index != -1) {
            stores.removeAt(index)
            notifyItemRemoved(index)
        }

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMarcajeBinding.bind(view)

        fun setListener(marcajesEntity: MarcajesEntity) {
            with(binding.root) {


                setOnClickListener { listener.onClick(marcajesEntity.id) }

                setOnLongClickListener {
                    listener.onDeleteMarcaje(marcajesEntity)
                    true
                }
            }

            binding.cbFavorite.setOnClickListener {
                listener.onFavoriteMarcaje(marcajesEntity)
            }
        }
    }
}


