package com.kursatkumsuz.marsrealestate.view.fragment

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {

    private lateinit var binding : FragmentGetStartedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStartedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextColor()
        navigateToFeedFragment()
    }

    /**
     * Sets color for TextView
     */
    private fun setTextColor() {
        val text = "<font color=#FFFFFF>Let's Explore the</font> <br></br> <font color=#F9AD1A>Solor System</font> <br></br> <font color=#FFFFFF>with</font> <font color=#F9AD1A>Explorer</font>"
        binding.getStartedText.text = Html.fromHtml(text)
    }
    /**
     * Navigates -> FeedFragment
     */
    private fun navigateToFeedFragment() {
        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_feedFragment)
        }
    }
}