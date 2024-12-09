package com.example.jetpack_compose.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.jetpack_compose.R
import com.example.jetpack_compose.data.CharacterPagedListAdapter
import com.example.jetpack_compose.data.CharacterPagedListViewModel
import com.example.jetpack_compose.data.EpisodeAdapter
import com.example.jetpack_compose.data.EpisodeViewModel
import com.example.jetpack_compose.databinding.FragmentBlankBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

class BlankFragment() : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!


    private val viewModelEpisode: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter()
    private val viewModelCharacter: CharacterPagedListViewModel by viewModels()
    private val pagedAdapterCharacter =
        CharacterPagedListAdapter { character -> onItemClick(character) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listItem.adapter = pagedAdapterCharacter

        viewModelCharacter.pagedCharacter.onEach {
            Log.d("BlankFragment", "BlankFragment   viewModel.pagedCharacter.onEach $it")
            pagedAdapterCharacter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)


    }

    private fun onItemClick(character: com.example.jetpack_compose.entity.Character) {
        runBlocking {
            val bundle = Bundle()

            bundle.putLong("idCharacter", character.id)
            Log.d("BlankFragment", "BlankFragment   idCharacter =  ${character.id}")

            bundle.putString("nameCharacter", character.name)
            Log.d("BlankFragment", "BlankFragment   nameCharacter =  ${character.name}")

            bundle.putString("lastLocationCharacter", character.location.name)
            Log.d(
                "BlankFragment",
                "BlankFragment   lastLocationCharacter =  ${character.location.name}"
            )

            bundle.putString("liveStatusCharacter", character.status)
            Log.d("BlankFragment", "BlankFragment   liveStatusCharacter =  ${character.status}")

            bundle.putString("imageCharacter", character.image)
            Log.d("BlankFragment", "BlankFragment   imageCharacter =  ${character.image}")

            bundle.putString("speciesCharacter", character.species)
            Log.d("BlankFragment", "BlankFragment   speciesCharacter =  ${character.species}")

            bundle.putString("originCharacter", character.origin.name)
            Log.d("BlankFragment", "BlankFragment   originCharacter =  ${character.origin.name}")

            bundle.putString("episodeCharacter", character.episode.toString())
            Log.d("BlankFragment", "BlankFragment   episodeCharacter =  ${character.episode}")

            val size = character.episode.size
            bundle.putInt("size", size)
            Log.d("BlankFragment", "BlankFragment   size =  $size")

            val episodeEpisode = viewModelEpisode.loadEpisodes(character.id.toInt()).episode
            Log.d("BlankFragment", "BlankFragment   episodeEpisode =  $episodeEpisode")
            bundle.putString("episodeEpisode", episodeEpisode)

            val nameEpisode = viewModelEpisode.loadEpisodes(character.id.toInt()).name
            Log.d("BlankFragment", "BlankFragment   nameEpisode =  $nameEpisode")
            bundle.putString("nameEpisode", nameEpisode)

            val air_dateEpisode = viewModelEpisode.loadEpisodes(character.id.toInt()).air_date
            Log.d("BlankFragment", "BlankFragment   air_dateEpisode =  $air_dateEpisode")
            bundle.putString("air_dateEpisode", air_dateEpisode)

            findNavController().navigate(R.id.action_blankFragment_to_blankFragment2, bundle)
        }
    }

    override fun onDestroyView() {
        Log.d("BlankFragment", "BlankFragment DestroyView")
        super.onDestroyView()
        _binding = null
    }

}
