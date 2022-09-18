package com.kursatkumsuz.marsrealestate.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.kursatkumsuz.marsrealestate.databinding.FragmentDetailBinding
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment @Inject constructor(
    private val glide: RequestManager
) : Fragment() {

    private lateinit var selectedData: Array<MarsModel>
    private lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: CartViewModel
    private var idList = ArrayList<String>()
    private var price: Int = 0
    private var id: String = ""
    private var type: String = ""
    private var image: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            selectedData = DetailFragmentArgs.fromBundle(it).data
        }

        viewModel = ViewModelProvider(requireActivity())[CartViewModel::class.java]
        setValues()
        init()
        getMarsIdFromRoom()
        saveDatabase()
    }

    /**
     * Sets values that passed
     */
    private fun setValues() {
        for (data in selectedData) {
            id = data.id
            price = data.price
            type = data.type
            image = data.image
        }
    }
    /**
     * Sets values to views
     */
    private fun init() {
        binding.apply {
            glide.load(image).into(marsImageView)
            idText.text = id
            priceText.text = "$$price"
            typeText.text = type
        }
    }

    /**
     * Checks whether the data to be recorded already exists
     */
    private fun saveDatabase() {
        binding.addCartButton.setOnClickListener {

            if (idList.contains(id)) {
                Toast.makeText(context, "Already added to cart", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.makeMars(price, id, type, image)
            }
        }
    }
    /**
     * Gets all Id from room database
     */
    private fun getMarsIdFromRoom() {
        viewModel.marsList.observe(viewLifecycleOwner, Observer { mars ->
            mars?.let {
                for (data in mars) {
                    idList.addAll(listOf(data.id))
                    println("MARS LIST $idList")
                }
            }
        })
    }

}