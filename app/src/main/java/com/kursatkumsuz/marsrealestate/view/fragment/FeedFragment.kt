package com.kursatkumsuz.marsrealestate.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.kursatkumsuz.marsrealestate.adapter.MarsAdapter
import com.kursatkumsuz.marsrealestate.util.Status
import com.kursatkumsuz.marsrealestate.databinding.FragmentFeedBinding
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.viewmodel.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeedFragment @Inject constructor(
    private val adapter: MarsAdapter
) : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedViewModel
    private var list = ArrayList<MarsModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set LayoutManager of RecyclerView
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        //Set ViewModel
        viewModel = ViewModelProvider(this)[FeedViewModel::class.java]
        observeLiveData()

        binding.cartButton.setOnClickListener {
            Navigation.findNavController(it).navigate(FeedFragmentDirections.actionFeedFragmentToCartFragment())
        }

    }


    /**
     * Observes live data in ViewModel
     */
    private fun observeLiveData() {
        viewModel.dataList.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data ->
                        list.addAll(data)
                        adapter.dataList = list
                        binding.recyclerView.adapter = adapter
                    }
                    binding.lottieAnimationView.visibility = View.GONE
                }
                Status.ERROR -> {
                    Toast.makeText(context, "No Data!", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    binding.lottieAnimationView.visibility = View.VISIBLE
                }
            }
        })
    }
}