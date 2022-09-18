package com.kursatkumsuz.marsrealestate.view.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.kursatkumsuz.marsrealestate.adapter.CartAdapter
import com.kursatkumsuz.marsrealestate.adapter.MarsAdapter
import javax.inject.Inject

class MarsFragmentFactory @Inject constructor(
    private val listAdapter: MarsAdapter,
    private val cartAdapter: CartAdapter,
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            FeedFragment::class.java.name -> FeedFragment(listAdapter)
            DetailFragment::class.java.name -> DetailFragment(glide)
            CartFragment::class.java.name -> CartFragment(cartAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}