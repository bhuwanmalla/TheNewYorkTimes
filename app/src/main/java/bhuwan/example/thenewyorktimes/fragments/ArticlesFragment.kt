package bhuwan.example.thenewyorktimes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import bhuwan.example.thenewyorktimes.adapters.ArticlesAdapter
import bhuwan.example.thenewyorktimes.databinding.FragmentArticlesBinding.inflate
import bhuwan.example.thenewyorktimes.databinding.FragmentArticlesBinding
import bhuwan.example.thenewyorktimes.models.Doc
import bhuwan.example.thenewyorktimes.viewmodel.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private val articlesNY = mutableListOf<Doc>()
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var viewModel: ArticlesViewModel

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

        viewModel = ViewModelProvider(requireActivity())[ArticlesViewModel::class.java]

        observeData()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchedData()
        }

    }


    private fun observeData() {
        viewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
            articles?.response?.docs?.let { articleData ->
                articlesNY.clear()
                articlesNY.addAll(articleData)
                articlesAdapter.notifyDataSetChanged()
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.swipeRefreshLayout.isRefreshing = isLoading

        })

    }

    private fun setUpRecyclerView() {
        articlesAdapter = ArticlesAdapter(articlesNY, requireContext())
        binding.recyclerView.adapter = articlesAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


}