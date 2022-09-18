package com.kursatkumsuz.marsrealestate.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.adapter.CartAdapter
import com.kursatkumsuz.marsrealestate.databinding.FragmentCartBinding
import com.kursatkumsuz.marsrealestate.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CartFragment @Inject constructor(
    private val adapter : CartAdapter
) : Fragment() {


    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        /**
         * if recyclerview item swipe to left , delete item
         * @param viewHolder for ViewHolder of RecyclerView
         */
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedMars = adapter.marsList[layoutPosition]
            viewModel.deleteMars(selectedMars)
        }

    }

    private lateinit var binding: FragmentCartBinding
    lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set ViewModel
        viewModel = ViewModelProvider(requireActivity())[CartViewModel::class.java]
        //Call functions
        observeData()
        setRecyclerView()
    }

    /**
     * Sets LayoutManager for RecyclerView
     * Sets adapter for RecyclerView
     * Sets ItemTouchHelper
     */
    private fun setRecyclerView() {
        binding.apply {
            cartRecyclerView.layoutManager = LinearLayoutManager(context)
            cartRecyclerView.adapter = adapter
            ItemTouchHelper(swipeCallBack).attachToRecyclerView(cartRecyclerView)
        }
    }

    private fun observeData() {
        viewModel.marsList.observe(viewLifecycleOwner , Observer { mars ->
            mars?.let {
                adapter.marsList = mars
            }
        })
    }

}