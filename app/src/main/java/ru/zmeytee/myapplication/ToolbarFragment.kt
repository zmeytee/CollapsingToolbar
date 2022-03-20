package ru.zmeytee.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dev.chrisbanes.insetter.applyInsetter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.core.scrollChangeEvents
import ru.zmeytee.myapplication.databinding.FragmentToolbarBinding

class ToolbarFragment: Fragment(R.layout.fragment_toolbar) {

    private var _binding: FragmentToolbarBinding? = null
    private val binding: FragmentToolbarBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            appBar.applyInsetter {
                type(statusBars = true) {
                   padding()
                }
            }

            val paddingBottom = nestedScroll.paddingBottom
            nestedScroll.clipToPadding = false
            ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
                nestedScroll.updatePadding(bottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom + paddingBottom)
                insets
            }

            nestedScroll
                .scrollChangeEvents()
                .onEach {
                    val canScroll = it.view.canScrollVertically(-1)
                    appBar.isSelected = canScroll
                }
                .launchIn(viewLifecycleOwner.lifecycleScope)

            toolbar.setNavigationOnClickListener {
                Toast.makeText(requireContext(), "Back", Toast.LENGTH_SHORT).show()
            }

            toolbar.setOnMenuItemClickListener {
                Toast.makeText(requireContext(), "Menu", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

}