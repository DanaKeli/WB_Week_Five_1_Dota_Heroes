package com.example.wb_week_five_1.presentation.heroes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wb_week_five_1.R
import com.example.wb_week_five_1.databinding.FragmentHeroesListBinding
import com.example.wb_week_five_1.domain.Hero
import com.example.wb_week_five_1.presentation.hero.HeroFragment


class HeroesListFragment : Fragment() {

    companion object {
        const val REQUEST_KEY = "requestKey"
        const val BUNDLE_KEY = "bundleKey"
    }

    private var _binding: FragmentHeroesListBinding? = null
    private val binding: FragmentHeroesListBinding get() = _binding!!
    private lateinit var vm: HeroesVM
    private lateinit var adapter: HeroesAdapter
    private lateinit var fm: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeroesListBinding.inflate(inflater, container, false)

        initViews()

        fm = requireActivity().supportFragmentManager

        vm = ViewModelProvider(this)[HeroesVM::class.java]
        vm.onCreate(requireContext())
        vm.heroesList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        setupClickListener()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        adapter = HeroesAdapter()
        binding.rvHeroesList.adapter = adapter
        binding.rvHeroesList.layoutManager = GridLayoutManager(context, 3)
    }

    private fun setupClickListener() {
        adapter.onItemClickListener = {
            fm.setFragmentResult(REQUEST_KEY, bundleOf(BUNDLE_KEY to it))
            fm.beginTransaction()
                .replace(R.id.main_container, HeroFragment())
                .commit()
        }
    }
}