package bhuwan.example.thenewyorktimes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import bhuwan.Result
import bhuwan.example.thenewyorktimes.adapters.TopStoriesAdapter
import bhuwan.example.thenewyorktimes.databinding.FragmentArticlesBinding.inflate
import bhuwan.example.thenewyorktimes.databinding.FragmentArticlesBinding
import bhuwan.example.thenewyorktimes.viewmodel.TopStoriesViewModel


class TopStoriesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    lateinit var storiesAdapter: TopStoriesAdapter
    private val stories = mutableListOf<Result>()
    lateinit var viewModel: TopStoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        viewModel = ViewModelProvider(requireActivity())[TopStoriesViewModel::class.java]

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchStories()
        }

        observeData()

    }

    private fun observeData(){

        viewModel.topStories.observe(viewLifecycleOwner, Observer { story ->
           story.results?.let { results ->
               stories.clear()
               stories.addAll(results)
               storiesAdapter.notifyDataSetChanged()
           }
        })


        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.swipeRefreshLayout.isRefreshing = isLoading

        })
    }

    private fun setUpRecyclerView(){
        storiesAdapter = TopStoriesAdapter(requireContext(),stories)
        binding.recyclerView.apply {
            adapter = storiesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}