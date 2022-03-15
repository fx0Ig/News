package com.example.news.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.news.databinding.FragmentOverviewBinding
import java.util.*
import androidx.recyclerview.widget.DividerItemDecoration





class OverviewFragment : Fragment(), ArticleClickListener {

    private val viewModel: NewsViewModel by activityViewModels()
    private lateinit var binding: FragmentOverviewBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter(this)
        binding.recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(
            binding.root.context,
            LinearLayout.VERTICAL
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        viewModel.news.observe(viewLifecycleOwner) {
            adapter.articleList = it
        }

    }

    override fun onItemClick(position: Int) {
        viewModel.articlePosition = position
        val action = OverviewFragmentDirections.actionOverviewFragmentToSecondScreenFragment()
        findNavController().navigate(action)
    }


}