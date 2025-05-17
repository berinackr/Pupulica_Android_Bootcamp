package com.example.colombiacoffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.colombiacoffee.databinding.FragmentCoffeeDetailBinding

class CoffeeDetailFragment : Fragment() {

    private var _binding: FragmentCoffeeDetailBinding? = null
    private val binding get() = _binding!!

    private val args: CoffeeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoffeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            coffeeDetailName.text = args.coffeeName
            coffeeDetailPrice.text = args.coffeePrice
            coffeeDetailImage.setImageResource(args.coffeeImageResId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
