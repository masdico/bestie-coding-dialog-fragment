package my.masdico.dialogfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import my.masdico.dialogfragment.databinding.FragmentCelebritiesBinding

class FragmentCelebrities : DialogFragment() {
    private var _binding: FragmentCelebritiesBinding? = null
    private val binding: FragmentCelebritiesBinding get() = _binding!!
    private var voteListener: OnVoteListener? = null

    interface OnVoteListener {
        fun getCelebName(celeb: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCelebritiesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVoteCeleb.setOnClickListener {
            val celeb = when(binding.rgCelebrities.checkedRadioButtonId){
                R.id.rb_celebrity1 -> binding.rbCelebrity1.text.toString()
                R.id.rb_celebrity2 -> binding.rbCelebrity2.text.toString()
                R.id.rb_celebrity3 -> binding.rbCelebrity3.text.toString()
                R.id.rb_celebrity4 -> binding.rbCelebrity4.text.toString()
                R.id.rb_celebrity5 -> binding.rbCelebrity5.text.toString()
                R.id.rb_celebrity6 -> binding.rbCelebrity6.text.toString()
                R.id.rb_celebrity7 -> binding.rbCelebrity7.text.toString()
                R.id.rb_celebrity8 -> binding.rbCelebrity8.text.toString()
                R.id.rb_celebrity9 -> binding.rbCelebrity9.text.toString()
                R.id.rb_celebrity10 -> binding.rbCelebrity10.text.toString()
                R.id.rb_celebrity11 -> binding.rbCelebrity11.text.toString()
                R.id.rb_celebrity12 -> binding.rbCelebrity12.text.toString()
                R.id.rb_celebrity13 -> binding.rbCelebrity13.text.toString()
                R.id.rb_celebrity14 -> binding.rbCelebrity14.text.toString()
                R.id.rb_celebrity15 -> binding.rbCelebrity15.text.toString()
                else -> ""
            }
            voteListener?.getCelebName(celeb)
            dialog?.dismiss()
        }

        binding.btnCloseDialog.setOnClickListener {
            voteListener?.getCelebName("no vote")
            dialog?.cancel()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is FragmentHome) {
            this.voteListener = (parentFragment as FragmentHome).voteListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.voteListener = null
    }
}