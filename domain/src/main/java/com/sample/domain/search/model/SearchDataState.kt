package com.sample.domain.search.model

/**
 * Holds states for handling search request.
 * */
sealed class SearchDataState {
    /**
     * Initial state.
     * */
    data object Idle : SearchDataState()

    /**
     * Loading state.
     * */
    data object Loading : SearchDataState()

    /**
     * Loaded successfully state.
     * */
    data class Success(val searchData: SearchData) : SearchDataState()

    /**
     * Error state.
     * */
    data class Error(val error: Exception) : SearchDataState()
}