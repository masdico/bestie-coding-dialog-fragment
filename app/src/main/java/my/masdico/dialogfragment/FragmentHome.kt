package my.masdico.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import my.masdico.dialogfragment.databinding.FragmentHomeBinding

class FragmentHome : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvChosenCelebrity.text = getString(R.string.text3)
        binding.btnShowDialog.setOnClickListener {
            val fragmentManager = childFragmentManager
            FragmentCelebrities().show(fragmentManager, FragmentCelebrities::class.java.simpleName)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}