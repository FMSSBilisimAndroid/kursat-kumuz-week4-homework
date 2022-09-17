package com.kursatkumsuz.marsrealestate.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.kursatkumsuz.marsrealestate.adapter.MarsAdapter
import javax.inject.Inject

class MarsFragmentFactory @Inject constructor(
    private val adapter: MarsAdapter,
    private val glide: RequestManager
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            FeedFragment::class.java.name -> FeedFragment(adapter)
            DetailFragment::class.java.name -> DetailFragment(glide)
            else -> super.instantiate(classLoader, className)
        }
    }
}