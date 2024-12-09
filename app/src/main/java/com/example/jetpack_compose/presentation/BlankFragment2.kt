package com.example.jetpack_compose.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpack_compose.R
import com.example.jetpack_compose.data.EpisodeAdapter
import com.example.jetpack_compose.data.EpisodeViewModel
import com.example.jetpack_compose.databinding.FragmentBlank2Binding


class BlankFragment2() : Fragment() {
    private var _binding: FragmentBlank2Binding? = null
    private val binding get() = _binding!!
    private val viewModelEpisode: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ScreenPreview2 {
                val bundle = Bundle()

                val episodeCharacter2 = arguments?.getString("episodeCharacter")
                Log.d("BlankFragment2", "BlankFragment2   episodeCharacter2 =  $episodeCharacter2")
                bundle.putString("episodeCharacter2", episodeCharacter2)

                val navController = findNavController()
                navController.navigate(R.id.action_blankFragment2_to_blankFragment3, bundle)
            }
        }

    }

    override fun onDestroyView() {
        Log.d("BlankFragment2", "BlankFragment2 DestroyView")
        super.onDestroyView()
        _binding = null
    }

    @Composable
    fun ScreenPreview2(onClick: () -> Unit) {

        val name2 = arguments?.getString("nameCharacter")
        Log.d("BlankFragment2", "BlankFragment2   name2 =  $name2")

        val lastLocation2 = arguments?.getString("lastLocationCharacter")
        Log.d("BlankFragment2", "BlankFragment2   lastLocation2 =  $lastLocation2")

        val liveStatus2 = arguments?.getString("liveStatusCharacter")
        Log.d("BlankFragment2", "BlankFragment2   liveStatus2 =  $liveStatus2")

        val img2 = arguments?.getString("imageCharacter")
        Log.d("BlankFragment2", "BlankFragment2   img2 =  $img2")

        val species2 = arguments?.getString("speciesCharacter")
        Log.d("BlankFragment2", "BlankFragment2   species2 =  $species2")

        val origin2 = arguments?.getString("originCharacter")
        Log.d("BlankFragment2", "BlankFragment2   origin2 =  $origin2")

        val episode2 = arguments?.getString("episodeCharacter")
        Log.d("BlankFragment2", "BlankFragment2   episode2 =  $episode2")

        val painter = rememberAsyncImagePainter(img2)
        fun ImageAlive(): Int {
            var image: Int? = null
            when (liveStatus2) {
                "Alive" -> image = (R.drawable.greencircle)
                "Dead" -> image = (R.drawable.redcircle)
                else -> image = (R.drawable.greycircle)
            }
            return image
        }

        Column {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .size(
                        width = 400.dp,
                        height = 200.dp,
                    ),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,

                )
            Text(
                "$name2",
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    top = 10.dp
                )
            )

            Column {
                Text(
                    "Live status:",
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier.padding(
                        start = 2.dp, end = 2.dp, top = 30.dp, bottom = 5.dp
                    )
                )
                Row {
                    Image(
                        painter = painterResource(id = ImageAlive()),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                end = 10.dp,
                            )
                            .size(
                                width = 10.dp, height = 10.dp
                            ),

                        )
                    Text(
                        "$liveStatus2",
                        color = Color.White,
                        fontSize = 20.sp,

                        )
                }
            }

            Text(
                "Species and gender:",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 2.dp, end = 2.dp, top = 30.dp, bottom = 5.dp
                )
            )
            Row {
                Text(
                    "$species2",
                    color = Color.White,
                )
                Text(
                    "gender",
                    color = Color.White,
                )
            }
            Text(
                "Last known location:",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 2.dp, end = 2.dp, top = 30.dp, bottom = 5.dp
                )
            )
            Text(
                "$lastLocation2",
                color = Color.White,
            )

            Text(
                "First seen in:",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 2.dp, end = 2.dp, top = 30.dp, bottom = 5.dp
                )
            )
            Text(
                "$origin2",
                color = Color.White,
            )

            Text(
                "Episodes:",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 2.dp, end = 2.dp, top = 30.dp, bottom = 5.dp
                )
            )
            Text(
                "$episode2",
                color = Color.White,
            )
            Text(
                "",
                color = Color.White,
            )

        }
    }

    @Preview
    @Composable
    fun ClickableImagePreview() {
        ScreenPreview2(onClick = {})
    }

}
