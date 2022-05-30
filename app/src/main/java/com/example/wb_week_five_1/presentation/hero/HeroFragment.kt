package com.example.wb_week_five_1.presentation.hero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.size.Scale
import com.example.wb_week_five_1.R
import com.example.wb_week_five_1.data.HeroRepositoryImp.Companion.BASE_URL
import com.example.wb_week_five_1.databinding.FragmentHeroBinding
import com.example.wb_week_five_1.domain.Hero
import com.example.wb_week_five_1.presentation.heroes.HeroesListFragment
import com.example.wb_week_five_1.presentation.heroes.HeroesListFragment.Companion.BUNDLE_KEY
import com.example.wb_week_five_1.presentation.heroes.HeroesListFragment.Companion.REQUEST_KEY
import com.example.wb_week_five_1.presentation.heroes.HeroesVM

class HeroFragment : Fragment() {

    private var _binding: FragmentHeroBinding? = null
    private val binding: FragmentHeroBinding get() = _binding!!
    private lateinit var fm: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeroBinding.inflate(inflater, container, false)

        fm = requireActivity().supportFragmentManager
        fm.setFragmentResultListener(REQUEST_KEY, viewLifecycleOwner) { _, bundle ->
            val hero = bundle.get(BUNDLE_KEY) as Hero
            initVies(hero)
        }
        return binding.root
    }

    private fun initVies(hero: Hero) {
        binding.apply {
            tvName.text = hero.name
            tvHealth.text = hero.health.toString()
            tvMana.text = hero.mana.toString()
            tvAttackRange.text = hero.attack_range.toString()
            btnBack.setOnClickListener {
                fm.beginTransaction().replace(R.id.main_container, HeroesListFragment()).commit()
            }
            ivBigImage.load(BASE_URL + hero.img) {
                crossfade(true)
                scale(Scale.FILL)
            }
        }
    }
}