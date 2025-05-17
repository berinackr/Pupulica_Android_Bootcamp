package com.example.colombiacoffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colombiacoffee.adapter.CoffeeAdapter
import com.example.colombiacoffee.databinding.FragmentCoffeeListBinding
import com.example.colombiacoffee.model.Coffee

class CoffeeListFragment : Fragment() {

    private var _binding: FragmentCoffeeListBinding? = null
    private val binding get() = _binding!!

    private val coffeeList = listOf(
        Coffee("AMERICANO", R.drawable.americano, "₺35.00"),
        Coffee("CAPPUCCINO", R.drawable.cappuccino, "₺40.00"),
        Coffee("CARAMEL MACCHIATO", R.drawable.caramel_macchiato, "₺45.00"),
        Coffee("EQUINOX", R.drawable.equinox, "₺50.00")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoffeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.coffeeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.coffeeRecyclerView.adapter = CoffeeAdapter(coffeeList) { selectedCoffee ->
            val action = CoffeeListFragmentDirections
                .actionCoffeeListFragmentToCoffeeDetailFragment(
                    selectedCoffee.name,
                    selectedCoffee.price,
                    selectedCoffee.imageResId
                )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
