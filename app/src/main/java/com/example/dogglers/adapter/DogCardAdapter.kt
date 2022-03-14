/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.const.Layout.HORIZONTAL
import com.example.dogglers.const.Layout.VERTICAL
import com.example.dogglers.data.DataSource
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Inicialice los datos utilizando la lista que se encuentra en data/DataSource

    private val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declarar e inicializar todos los componentes de la interfaz de usuario del
        //  elemento de lista
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val textName: TextView = view!!.findViewById(R.id.dog_name)
        val textAge: TextView = view!!.findViewById(R.id.dog_age)
        val textViewHobbies: TextView = view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Utilice un condicional para determinar el tipo de diseño y establecerlo en consecuencia.
        //  si la variable de diseño es Layout.GRID, se debe utilizar el elemento de lista de cuadrícula.
        //  De lo contrario, se debe utilizar el elemento de lista vertical/horizontal.

        return when(layout){
            Layout.GRID->{
                val adapterLayout =  LayoutInflater.from(parent.context).
                inflate(R.layout.grid_list_item, parent, false)
                DogCardViewHolder(adapterLayout)
            }
            else->{
                val adapterLayout =  LayoutInflater.from(parent.context).
                inflate(R.layout.vertical_horizontal_list_item, parent, false)
                DogCardViewHolder(adapterLayout)
            }
        }

        // TODO Inflar el diseño

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
    }

    override fun getItemCount(): Int {
        return dataset.size
    }// TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Obtener los datos en la posición actual
        val item = dataset[position]

        // TODO: Establecer el recurso de imagen para el perro actual
        holder.imageView.setImageResource(item.imageResourceId)

        // TODO: Establecer el texto para el nombre del perro actual
        holder.textName.text = item.name

        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.textAge.text = resources?.getString(R.string.dog_age, item.age)

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.textViewHobbies.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
    }
}
