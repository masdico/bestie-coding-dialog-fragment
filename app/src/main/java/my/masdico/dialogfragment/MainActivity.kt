package my.masdico.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.masdico.dialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val fragmentManager = supportFragmentManager
        val findFragment = fragmentManager.findFragmentByTag(FragmentHome::class.java.simpleName)

        if (findFragment !is FragmentHome){
            fragmentManager.beginTransaction()
                .add(R.id.container_fragment, FragmentHome(), FragmentHome::class.java.simpleName)
                .commit()
        }
    }
}