package com.app.foodrecipe.screens

import android.os.Bundle
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityMainBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.fragement.MyTipsTrickListingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : KotlinBaseActivity(R.id.fragmentContainerView) {
    lateinit var binding: ActivityMainBinding
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        removeChefBottomBar() //. for remove + add create recipe button in bottom bar
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)


        binding.bottomNavigationView.isSelected


//        binding.bottomNavigationView.setOnItemSelectedListener {
//        Log.e("ewereeeeeeeeeeee",it.itemId.toString())
//            true
//        }
        setClick()
        openSideMenuBar()
    }

    private fun removeChefBottomBar() {
        val bottom = bottomNavigationView.menu
        bottom.removeItem(R.id.createRecipe)
        binding.addTipsTrickbutton.gone()

    }


//    private fun drawable() {
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeScreenFragement,
//                R.id.favouriteFragement,
//                R.id.tipsTrickFragement,
//                R.id.profileFragement
//            ), drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.showDrawer.setupWithNavController(navController)
//        bottomNavigationView.setupWithNavController(navController)
//    }

    private fun setClick() {
        binding.toolbar.menuIcon.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.addTipsTrickbutton.setOnClickListener {
            openA(CreateRecipeActivity::class)
        }
    }

    private fun openSideMenuBar() {

        binding.showDrawer.fbCloseSideMenu.setOnClickListener {
            binding.drawerLayout.close()
        }
        binding.showDrawer.tvsidehome.setOnClickListener {
            binding.drawerLayout.close()
            binding.bottomNavigationView.selectedItemId = R.id.homeScreenFragement
        }

        binding.showDrawer.tvsidefavourite.setOnClickListener {
            binding.drawerLayout.close()
            binding.bottomNavigationView.selectedItemId = R.id.favouriteFragement
        }

        binding.showDrawer.tvsidetipstrick.setOnClickListener {
            binding.drawerLayout.close()
            binding.bottomNavigationView.selectedItemId = R.id.tipsTrickFragement
        }
        binding.showDrawer.tvsideProfile.setOnClickListener {
            binding.drawerLayout.close()
            binding.bottomNavigationView.selectedItemId = R.id.profileFragement
        }
        binding.showDrawer.tvsideContactus.setOnClickListener {
            binding.drawerLayout.close()
            openA(ContactUsActivity::class)
        }

        binding.showDrawer.tvsidemyTips.setOnClickListener {
            binding.drawerLayout.close()
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_MY_TIPS_TRICK_LISTING.toString())
            openA(CommonActivity::class, bundle)
        }
        binding.showDrawer.tvsidemyrecipe.setOnClickListener {
            binding.drawerLayout.close()
            openA(MyRecipeListingActivity::class)
        }


        binding.showDrawer.tvsideSetting.setOnClickListener {
            binding.drawerLayout.close()
            openA(EditProfileActivity::class)
        }
        binding.showDrawer.tvsideAboutUs.setOnClickListener {
            binding.drawerLayout.close()
            openA(AboutUs::class)
        }
        binding.showDrawer.lllogoutcontainer.setOnClickListener {
            binding.drawerLayout.close()
            openA(AuthActivityContainer::class)
        }

    }


}
