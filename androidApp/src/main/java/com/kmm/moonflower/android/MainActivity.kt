package com.kmm.moonflower.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
//import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.MenuProvider
import androidx.core.view.WindowCompat
import com.google.accompanist.themeadapter.material.MdcTheme
import com.kmm.moonflower.Greeting
import com.kmm.moonflower.android.compose.SunflowerApp
import com.kmm.moonflower.android.compose.home.SunflowerPage
import com.kmm.moonflower.android.viewmodels.PlantListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PlantListViewModel by viewModels()

    private val menuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.menu_plant_list, menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return when (menuItem.itemId) {
                R.id.filter_zone -> {
                    viewModel.updateData()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            MdcTheme {
                SunflowerApp(
                    onAttached = { toolbar ->
//                     TODO   setSupportActionBar(toolbar)
                    },
                    onPageChange = { page ->
                        when (page) {
                            SunflowerPage.MY_GARDEN -> removeMenuProvider(menuProvider)
                            SunflowerPage.PLANT_LIST -> addMenuProvider(
                                menuProvider,
                                this
                            )
                        }
                    }
                )
            }

//            origin project m3
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    GreetingView(Greeting().greet())
//                }
//            }
        }
    }
}

//            origin project kmm
//@Composable
//fun GreetingView(text: String) {
//    Text(text = text)
//}
//
//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        GreetingView("Hello, Android!")
//    }
//}
