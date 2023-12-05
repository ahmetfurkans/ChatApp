package com.galataapplab.chatapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.galataapplab.chatapp.core.presentation.navigation.Navigation
import com.galataapplab.chatapp.core.presentation.theme.ChatAppTheme
import com.galataapplab.chatapp.phonePicker.CountryCard
import com.galataapplab.chatapp.phonePicker.CountryData
import com.galataapplab.chatapp.phonePicker.PhonePickerSheetLayout
import com.galataapplab.chatapp.phonePicker.countryList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    //                    SharedViewModelSample()
                    // Navigation(navController = navController, scaffoldState = scaffoldState)
                    var expanded by remember { mutableStateOf(true) }
                    var selectedCountry by remember { mutableStateOf<CountryData?>(null) }

                    PhonePickerSheetLayout(show = expanded,
                        onItemSelected = { selectedCountry = it; expanded = false },
                        onDismissRequest = { expanded = false },
                        content = {
                            Text(text = selectedCountry?.cNames ?: "choose",
                                Modifier.clickable { expanded = true })
                        })
                }
            }
        }
    }
}