package com.compose.playground.drawer

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.compose.playground.ui.theme.ComposePlaygroundTheme

class DrawerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ComposePlaygroundTheme {
                DrawerFragmentContent()
            }
        }
    }
}

@Composable
private fun DrawerFragmentContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.holo_purple)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Drawer",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 40.sp
                )
            )
        }
    }
}

@Preview
@Composable
private fun DetailFragmentTwoContentPreview() {
    ComposePlaygroundTheme {
        DrawerFragmentContent()
    }
}
