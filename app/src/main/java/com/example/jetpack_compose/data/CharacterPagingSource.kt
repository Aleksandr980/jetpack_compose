package com.example.jetpack_compose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class CharacterPagingSource : PagingSource<Int, com.example.jetpack_compose.entity.Character>() {

    val pagedListRepository = PagedListRepository()
    override fun getRefreshKey(state: PagingState<Int, com.example.jetpack_compose.entity.Character>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.jetpack_compose.entity.Character> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            pagedListRepository.getCharacterList(page).results
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    private companion object {
        private val FIRST_PAGE = 1
    }
}






