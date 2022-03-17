package com.compose.playground.masterdetail.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
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

class DetailFragmentTwo : Fragment() {

    companion object {
        fun newInstance() = DetailFragmentTwo()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ComposePlaygroundTheme {
                DetailFragmentTwoContent()
            }
        }
    }
}

@Composable
private fun DetailFragmentTwoContent() =
    BoxWithConstraints(
        Modifier
            .background(color = colorResource(id = android.R.color.holo_blue_dark))
            .fillMaxSize()
    ) {
        println("Box width = $maxWidth")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detail item 2",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 40.sp
                )
            )
            Divider(Modifier.fillMaxWidth())
        }
    }


@Preview
@Composable
private fun DetailFragmentTwoContentPreview() {
    ComposePlaygroundTheme {
        DetailFragmentTwoContent()
    }
}
