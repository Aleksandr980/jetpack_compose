package com.example.jetpack_compose.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jetpack_compose.R
import com.example.jetpack_compose.api.URL
import com.example.jetpack_compose.data.EpisodeAdapter
import com.example.jetpack_compose.data.EpisodeViewModel
import com.example.jetpack_compose.databinding.FragmentBlank3Binding
import com.example.jetpack_compose.entity.Episode
import kotlinx.coroutines.runBlocking

class BlankFragment3 : Fragment {
    constructor() : super()

    private var _binding: FragmentBlank3Binding? = null
    private val binding get() = _binding!!


    private val viewModelEpisode: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            LazyEpisodeList()
        }
    }


    override fun onDestroyView() {
        Log.d("BlankFragment3", "BlankFragment3 DestroyView")
        super.onDestroyView()
        _binding = null
    }
    private fun onItemClick(character: com.example.jetpack_compose.entity.Character) {

    }
    @Preview
    @Composable
    fun LazyEpisodeList() {

        val lengthURL = URL.length + 13 //https://rickandmortyapi.com =27 знаков + /api/episode/ = 13 знаков = 40 знаков
        Log.d("BlankFragment3", "BlankFragment3   lengthURL =  $lengthURL")

        val episode: List<String>? =
            arguments?.getString("episodeCharacter2")?.replace("]", "")
                ?.replace("[", "")?.split(", ")?.toList()
        Log.d("BlankFragment3", "BlankFragment3   episode =  $episode")

        val episodeSize = episode?.size

        var data: MutableList<Episode> = emptyList<Episode>().toMutableList()

        if (episodeSize != null) {
            for (i in 0..episodeSize - 1) {
                val getNumber =
                    episode.get(i).subSequence(lengthURL, episode[i].length).toString()
                val number = getNumber.toInt()
                data.add(i, runBlocking { viewModelEpisode.loadEpisodes(number) })
            }
        }

        Column {
            Row {
                Text(
                    text = "<",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clickable(
                            enabled = true,
                            "<",
                            null,
                            onClick = {findNavController().popBackStack()}
                        )
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "Person detalis",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                text = "Episodes:",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(episodeSize!!) { i ->

                    Column(
                        modifier = Modifier
                            .background(Color.Gray, RectangleShape)
                            .border(8.dp, Color.Black, shape = CutCornerShape(8.dp))
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                //.padding(start = 16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .width(304.dp),
                                // .padding(start = 0.dp),
                                text = "${data[i].name}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "${data[i].episode}",
                                // modifier = Modifier.padding(end = 0.dp),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        }
                        Text(
                            modifier = Modifier.padding(start = 0.dp, top = 10.dp),
                            text = "${data[i].air_date}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                }
            }

        }
    }
}















